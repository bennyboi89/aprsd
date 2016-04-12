package no.polaric.aprsd.http;
import no.polaric.aprsd.*;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.io.IOException;
import org.simpleframework.http.Cookie;
import org.simpleframework.http.Request;
import org.simpleframework.http.socket.*;
import org.simpleframework.http.socket.service.Service;
import org.simpleframework.transport.*;
import java.util.function.*;
import com.fasterxml.jackson.databind.*;


/** Send events to clients through WebSockets. Let clients subscribe. */

public abstract class WsNotifier extends ServerBase implements Service
{

   public abstract class Client implements FrameListener {
   
      protected final FrameChannel _chan; 
      protected final long _uid;
    
      protected boolean _admin=false, _sar=false, _login=false; 
      protected String _username;
   
   
      public Client(FrameChannel ch, long uid) {
         _chan = ch;
         _uid = uid;
      }
   
   
      public final void setUsername(String uname) {
            _username = uname; 
            _admin = authorizedForAdmin(_username);
            _sar = authorizedForUpdate(_username);
            _login = (_username != null);
       }
       
   
      public void send(Frame frame) throws IOException
         { _chan.send(frame); }
      
   
      public void sendText(String text) throws IOException
         { send(new DataFrame(FrameType.TEXT, text)); }
   
      public long getUid() 
         { return _uid; }
         
      public String getUsername()
         { return _username; }
         
      public void close() throws IOException { 
         _chan.close(); 
         _clients.remove(_uid);
      }
      
   
      public void onFrame(Session socket, Frame frame) {
         FrameType type = frame.getType();
         String text = frame.getText();
         Request request = socket.getRequest();
         if(type == FrameType.TEXT) 
             onTextFrame(request, text);
      }

      
      /** 
       * Handler for text frame. To be defined in subclass.
       */
      public abstract void onTextFrame(Request request, String text);
      
   
      public void onError(Session socket, Exception cause) {
         _api.log().error("WsNotifier", "Socket error (" + cause + ")");
         if (!(cause instanceof org.simpleframework.transport.TransportException))
            cause.printStackTrace(System.out);
         try { _clients.remove(_uid); close(); } 
         catch (Exception e) {}
      }

   
      public void onClose(Session session, Reason cause) {
         _api.log().debug("WsNotifier", "Socket closed (" + cause + ")");
         _api.log().info("WsNotifier", "Unsubscribing closed client channel: "+_uid); 
         _clients.remove(_uid);
      }
      
   } /* class Client */

   
   /* Is this instance on a trusted configuration. */
   private boolean _trusted = false;
   
   /* Origin site. 
    * Trusted origin sites (regular expression) */
   private String _origin;
   private String _trustedOrigin; 
         
   /* Jackson JSON mapper */ 
   protected final static ObjectMapper mapper = new ObjectMapper();
   
   /* Map of clients */ 
   protected final Map<Long, FrameListener> _clients;
      
   
   public WsNotifier(ServerAPI api, boolean trusted) throws IOException {
       super(api);
      _trustedOrigin = _api.getProperty("trusted.orgin", ".*");
      _trusted = trusted;
      _clients = new ConcurrentHashMap<Long, FrameListener>();
   }  
     
     
   /** Factory method */
   public abstract Client newClient(FrameChannel ch, long uid);
     

   /** Return number of clients. */
   public int nClients() 
     { return _clients.size(); }
     
   
   /** 
    * Connect. Join the room. The user id is a long int which is 
    * assigned automatically.
    */
   public void connect(Session connection) {
      try {
          Request req = connection.getRequest();      
          long uid = getSession(req); 
              
          /* Check origin */
          _origin = req.getValue("Origin");
          if (_origin != null && _origin.matches(_trustedOrigin)) 
          {
              FrameChannel chan = connection.getChannel();
              Client client = newClient(chan, uid); 
              chan.register(client );
          
              /* We need to be sure that we can trust that the user
               * is who he says he is. Can we trust that getAuthUser is authenticated
               * if not, try to identify and authenticate. 
               */
              if (_trusted || trustUser(uid, req))
                  client.setUsername(getAuthUser(req));
                 
              if (subscribe(uid, client, req)) {
                 _api.log().info("WsNotifier", "Subscription success. User="+uid+(_trusted ? " (trusted chan)" : ""));
                 _clients.put(uid, client); 
              }
              else {
                 _api.log().info("WsNotifier", "Subscription rejected. User="+uid);
                 chan.close();
              }
           }
           else
              _api.log().info("WsNotifier", "Subscription rejected. Untrusted origin='"+_origin+"', user="+uid);
          
      } catch(Exception e) {
          _api.log().warn("WsNotifier", "Subscription failed: " + e);
          if (e instanceof NullPointerException)
            e.printStackTrace(System.out);
      }  
   }
   
   
   
   protected boolean trustUser(long uid, Request req) {
      return false; 
   }
   
   
   /**
    * Subscribe a client to the service. Should be overridden in subclass.
    * This may include authorization, preferences, etc.. 
    * @return true if subscription is accepted. False if rejected.
    */
   public boolean subscribe(long uid, Client client, Request req) 
      { return true; }
   
   
     
   /**
    * Distribute a object (as JSON) to the clients for which the 
    * predicate evaluates to true. 
    */
   public void postObject(Object myObj, Predicate<Client> pred) { 
      try { postText(mapper.writeValueAsString(myObj), pred); }
      catch (Exception e) {
          _api.log().warn("WsNotifier", "Cannot serialize object: " + e);
      }
   }
   
   
   /**
    * Distribute a text to the clients for which the 
    * predicate evaluates to true. 
    */
   public void postText(Function<Client,String> txt, Predicate<Client> pred) {
      try {          
         /* Distribute to all clients */
         for(long user : _clients.keySet()) {
            Client client = (Client) _clients.get(user);
            try {               
               if(client != null && pred.test(client)) 
                  client.sendText(txt.apply(client));
               
            } catch(Exception e){   
               if (e.getCause() instanceof TransportException) {
                  _clients.remove(user); 
                  _api.log().info("WsNotifier", "Unsubscribing closed client channel: "+user);       
               }
               else throw e;
            }
         }
      } catch(Exception e) {
         _api.log().error("WsNotifier", "Cannot distribute string: " + e);
         e.printStackTrace(System.out);
      }
   } 
   
   public void postText(String txt, Predicate<Client> pred) {
        postText(c->txt, pred);
   }
   
}
