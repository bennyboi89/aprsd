##########################################################################
## Change macros below according to your environment and your needs
##
## JAVAC: Java compiler
## JAR:   Jar archiver
##########################################################################

   CLASSDIR = classes
 LIBJACKSON = /usr/share/java/jackson-core.jar:/usr/share/java/jackson-databind.jar
    GETTEXT = /usr/share/java/gettext-commons.jar
  CLASSPATH = $(GETTEXT):$(LIBJACKSON):jcoord-polaric.jar:utf8-with-fallback-polaric.jar:/usr/share/java/RXTXcomm.jar:simple.jar
 # INSTALLDIR = /usr/local/polaric-aprsd
      JAVAC = javac -source 1.8 -target 1.8
       YACC = yacc
        LEX = jflex
        JAR = jar

# Review (and if necessary) change these if you are going to 
# install by using this makefile

   INSTALL_JAR = $(DESTDIR)/usr/share/java
   INSTALL_BIN = $(DESTDIR)/usr/bin
INSTALL_CONFIG = $(DESTDIR)/etc/polaric-aprsd
   INSTALL_WEB = $(DESTDIR)/usr/share/polaric
 INSTALL_DATA  = $(DESTDIR)/var/lib/polaric
   INSTALL_LOG = $(DESTDIR)/var/log/polaric
  INSTALL_SUDO = $(DESTDIR)/etc/sudoers.d
INSTALL_PLUGDIR= $(INSTALL_CONFIG)/config.d


##################################################
##  things below should not be changed
##
##################################################
    LIBDIR = _lib
 JAVAFLAGS =
 PACKAGES  = core i18n util channels httpd scala aprsd
 LANGUAGES = no


all: aprs

install: polaric-aprsd.jar
	install -d $(INSTALL_CONFIG)
	install -d $(INSTALL_PLUGDIR)
	install -d $(INSTALL_BIN)
	install -d $(INSTALL_JAR)
	install -d $(INSTALL_WEB)/icons $(INSTALL_WEB)/icons/alt $(INSTALL_WEB)/icons/signs $(INSTALL_WEB)/dicons
	install -d $(INSTALL_DATA)
	install -d $(INSTALL_SUDO)
	install -m 755 -d $(INSTALL_LOG)
	install -m 644 server.ini $(INSTALL_CONFIG)
	install -m 644 symbols $(INSTALL_CONFIG)
	install -m 644 trailcolours $(INSTALL_CONFIG)
	install -m 644 view.profiles $(INSTALL_CONFIG)
	install -m 644 *.jar $(INSTALL_JAR)
	install -m 644 icons/*.png $(INSTALL_WEB)/icons
	install -m 644 icons/alt/*.png $(INSTALL_WEB)/icons/alt
	install -m 644 icons/signs/*.png icons/signs/*.gif $(INSTALL_WEB)/icons/signs
	install -m 644 dicons/*.png $(INSTALL_WEB)/dicons
	install -m 644 style.css $(INSTALL_WEB)
	install -m 755 polaric-restart $(INSTALL_BIN)
	cp sudoers.d $(INSTALL_SUDO)/polaric-aprsd
	chmod 644 $(INSTALL_SUDO)/polaric-aprsd
	

aprs: $(LIBDIR)
	@make TDIR=$(LIBDIR) CLASSPATH=$(LIBDIR):$(CLASSPATH) compile     
	cd $(LIBDIR);jar cvf ../polaric-aprsd.jar *;cd ..


compile: $(PACKAGES)
	

$(CLASSDIR): 
	mkdir $(CLASSDIR)
	
		
$(LIBDIR):
	mkdir $(LIBDIR)

	
src/filter/Lexer.java : src/filter/filters.lex src/filter/filters.y
	cd src/filter;$(LEX) filters.lex
	
src/filter/Parser.java : src/filter/filters.y
	cd src/filter;$(YACC) -Jpackage=no.polaric.aprsd.filter filters.y
	
	
	
.PHONY : i18n
i18n: 
	bash msg-compile.sh $(LANGUAGES)
	

.PHONY : util
util: 
	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/util/*.java 
	
	
.PHONY : core
core: util src/filter/Parser.java src/filter/Lexer.java
	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/*.java  src/filter/*.java
	
	
.PHONY : aprsd
aprsd: 
	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/aprsd/*.java 
	

.PHONY : channels
channels: 
	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/channels/*.java 
	

	
#filter: core  src/filter/Parser.java src/filter/Lexer.java
#	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/filter/*.java

	
.PHONY : httpd
httpd: core
	$(JAVAC) -d $(TDIR) $(JAVAFLAGS) src/httpd/*.java 
	
	
.PHONY : scala
scala: core           
	scalac -d $(TDIR) -classpath $(LIBDIR):$(CLASSPATH) src/httpd/*.scala

	
clean:
	@if [ -e ${LIBDIR} ]; then \
		  rm -Rf $(LIBDIR); \
	fi 
	rm -f ./*~ src/*~ src/httpd/*~
