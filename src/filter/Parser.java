//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package no.polaric.aprsd.filter;



//#line 3 "filters.y"
import java.io.*;
import java.util.*;
import no.polaric.aprsd.ServerAPI;
//#line 21 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short STRING=257;
public final static short IDENT=258;
public final static short RELOP=259;
public final static short NUM=260;
public final static short BOOLEAN=261;
public final static short VALUE=262;
public final static short AND=263;
public final static short OR=264;
public final static short NOT=265;
public final static short ARROW=266;
public final static short PROFILE=267;
public final static short AUTOTAG=268;
public final static short PUBLIC=269;
public final static short INCLUDE=270;
public final static short ERROR=271;
public final static short TAG=272;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    7,    7,    8,    8,    8,   10,   10,    9,    9,
    6,    6,   12,   12,    4,    4,    4,    3,    3,    3,
    3,    3,    3,    3,    3,    2,    2,    1,    1,    1,
   11,   13,   13,    5,    5,   14,   14,
};
final static short yylen[] = {                            2,
    1,    2,    0,    1,    1,    1,    4,    1,    6,    1,
    1,    0,    2,    0,    6,    3,    2,    3,    2,    3,
    3,    3,    3,    1,    2,    3,    1,    3,    3,    1,
    4,    2,    0,    6,    2,    4,    2,
};
final static short yydefred[] = {                         3,
    0,    0,    8,    0,    0,   11,    0,    2,    4,    5,
    6,    0,   33,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   19,    0,   25,    0,    0,    7,    0,
   31,    0,   32,   14,   22,   23,   18,   20,    0,   35,
    0,    0,    0,    0,    0,    9,    0,   13,    0,    0,
   17,    0,    0,   37,    0,    0,   16,    0,   34,    0,
    0,   27,    0,   36,    0,    0,    0,   28,   29,   15,
   26,
};
final static short yydgoto[] = {                          1,
   62,   63,   19,   48,   33,    7,    2,    8,    9,   10,
   11,   42,   20,   50,
};
final static short yysindex[] = {                         0,
    0, -235,    0,  -54, -110,    0, -250,    0,    0,    0,
    0,  -38,    0, -238, -121,  -38,  -38, -236,  -55,  -37,
  -98, -232, -227,    0,  -23,    0,  -38,  -38,    0,  -30,
    0, -228,    0,    0,    0,    0,    0,    0, -226,    0,
  -92,  -40, -229,  -15, -213,    0, -224,    0, -212,  -36,
    0,  -12,  -75,    0,  -10, -222,    0, -207,    0, -206,
   -8,    0,  -34,    0, -248,   -5, -207,    0,    0,    0,
    0,
};
final static short yyrindex[] = {                         0,
    0,    1,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -27,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -35,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -33,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
  -11,    0,   -1,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=268;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         17,
    1,   17,   17,   29,   23,   21,   12,   56,   68,   67,
   30,   69,   13,   24,   24,   25,   14,   37,   32,   21,
    3,   26,    4,   21,   34,   38,   39,   35,   40,   36,
   43,   24,    5,    6,   27,   28,   27,   41,   27,   28,
   47,   53,   49,   51,   52,   54,   57,   58,   59,   60,
   61,   64,   65,   70,    0,   71,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   46,    0,    0,   31,   55,    0,
   66,   30,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   22,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   27,   28,    0,
    0,    0,    0,    0,    0,   44,    0,   15,   30,   15,
   15,    0,    0,    0,   16,    0,   16,   16,   21,   45,
   21,   18,    0,   18,   18,   24,   24,    0,   24,   27,
   28,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   12,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
    0,   40,   40,   59,  126,   41,   61,   44,  257,   44,
   44,  260,  123,   41,   16,   17,  267,   41,   20,  258,
  256,  258,  258,   59,  123,   27,   28,  260,   59,  257,
  123,   59,  268,  269,  263,  264,  263,  266,  263,  264,
   42,  266,  272,   59,  258,  258,   59,  123,   59,  272,
  258,  258,   61,   59,   -1,   67,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  125,   -1,   -1,  125,  125,   -1,
  125,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  259,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  263,  264,   -1,
   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  256,  258,
  258,   -1,   -1,   -1,  265,   -1,  265,  265,  264,  270,
  266,  272,   -1,  272,  272,  263,  264,   -1,  266,  263,
  264,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  267,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=272;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'",null,null,"','",
null,null,null,null,null,null,null,null,null,null,null,null,null,null,"';'",
null,"'='",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'{'",null,"'}'","'~'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"STRING","IDENT","RELOP","NUM","BOOLEAN",
"VALUE","AND","OR","NOT","ARROW","PROFILE","AUTOTAG","PUBLIC","INCLUDE","ERROR",
"TAG",
};
final static String yyrule[] = {
"$accept : input",
"input : stmts",
"stmts : stmts stmt",
"stmts :",
"stmt : profile",
"stmt : assignment",
"stmt : autotag",
"assignment : IDENT '=' expr ';'",
"assignment : error",
"profile : public PROFILE IDENT '{' rules '}'",
"profile : error",
"public : PUBLIC",
"public :",
"rules : rules rule",
"rules :",
"rule : expr ARROW '{' actions '}' ';'",
"rule : INCLUDE IDENT ';'",
"rule : error ';'",
"expr : '(' expr ')'",
"expr : NOT expr",
"expr : expr AND expr",
"expr : expr OR expr",
"expr : IDENT RELOP NUM",
"expr : IDENT '~' STRING",
"expr : IDENT",
"expr : TAG IDENT",
"actions : actions ',' action",
"actions : action",
"action : IDENT '=' STRING",
"action : IDENT '=' NUM",
"action : IDENT",
"autotag : AUTOTAG '{' tag_rules '}'",
"tag_rules : tag_rules tag_rule",
"tag_rules :",
"tag_rule : expr ARROW '{' tag_actions '}' ';'",
"tag_rule : error ';'",
"tag_actions : tag_actions ',' TAG IDENT",
"tag_actions : TAG IDENT",
};

//#line 207 "filters.y"

  private Action action; 
  private List<String> tagaction;
  private RuleSet ruleset; 
  private TagRuleSet tagrules; 
  private Map<String, RuleSet> profiles = new HashMap<String,RuleSet>(); 
  private Map<String, Pred> predicates = new HashMap<String,Pred>(); 
  
  private ServerAPI _api; 
  private String _filename;
  
  /* a reference to the lexer object */
  private Lexer lexer;

  /* interface to the lexer */
  private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      _api.log().error("ViewFilter", "IO error :"+e);
    }
    return yyl_return;
  }
  
  /* error reporting */
  public void yyerror (String error) {
     _api.log().error(null, "In config file '"+_filename+"', line "+lexer.line()+": " + error);
  }

  public Map<String, RuleSet> getProfiles() 
      { return profiles; }
      
  public TagRuleSet getTagRules () 
      { return tagrules; }
      
  public void parse()
      { yyparse(); }
      
  /* lexer is created in the constructor */
  public Parser(ServerAPI api, Reader r, String fname) {
    lexer = new Lexer(r, this);
    _api = api;
    _filename = fname; 
    
    /* Install predefined predicates */
    predicates.put("infra",    Pred.Infra()); 
    predicates.put("moving",   Pred.Moving());
    predicates.put("fulldigi", Pred.Infra(true,false));
    predicates.put("igate",    Pred.Infra(false,true));
  }

//#line 342 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 7:
//#line 39 "filters.y"
{  if (val_peek(3).sval.matches("infra|INFRA|moving|MOVING|fulldigi|FULLDIGI|igate|IGATE"))
                                   yyerror("Cannot redefine predicate '"+val_peek(3).sval+"'"); 
                                else
                                   predicates.put(val_peek(3).sval, (Pred) val_peek(1).obj); 
                              }
break;
case 9:
//#line 49 "filters.y"
{ if ((boolean)val_peek(5).obj) 
                                  ruleset.setPublic(); 
                               profiles.put(val_peek(3).sval, ruleset); 
                               _api.log().debug("ViewFilter", "View profile '"+val_peek(3).sval+"' ok");
                               ruleset=null; }
break;
case 11:
//#line 59 "filters.y"
{ yyval.obj = true; }
break;
case 12:
//#line 60 "filters.y"
{ yyval.obj = false; }
break;
case 13:
//#line 64 "filters.y"
{ if (val_peek(0).obj != null) 
                                 { ruleset.add((Rule)val_peek(0).obj); }
                             }
break;
case 14:
//#line 68 "filters.y"
{ ruleset = new RuleSet();  }
break;
case 15:
//#line 75 "filters.y"
{ yyval.obj = new Rule.Single((Pred) val_peek(5).obj, action); }
break;
case 16:
//#line 77 "filters.y"
{ yyval.obj = profiles.get(val_peek(1).sval); 
                                if (yyval.obj == null) 
                                   yyerror("Tried to INCLUDE unknown profile '"+val_peek(1).sval+"'");
                              }
break;
case 17:
//#line 85 "filters.y"
{  yyval.obj = null; }
break;
case 18:
//#line 90 "filters.y"
{  yyval.obj=val_peek(1).obj; }
break;
case 19:
//#line 92 "filters.y"
{  yyval.obj=Pred.NOT((Pred)val_peek(0).obj); }
break;
case 20:
//#line 94 "filters.y"
{  yyval.obj=Pred.AND((Pred)val_peek(2).obj, (Pred)val_peek(0).obj); }
break;
case 21:
//#line 96 "filters.y"
{  yyval.obj=Pred.OR((Pred)val_peek(2).obj, (Pred)val_peek(0).obj); }
break;
case 22:
//#line 98 "filters.y"
{   if (val_peek(2).sval.matches("scale|SCALE"))
                                     yyval.obj=Pred.Scale((Long) val_peek(0).obj, val_peek(1).sval);
                                  else if (val_peek(2).sval.matches("speed|SPEED"))
                                     yyval.obj=Pred.Speed((Long) val_peek(0).obj, val_peek(1).sval);
                                  else if (val_peek(2).sval.matches("max-speed|MAX-SPEED"))
                                     yyval.obj=Pred.MaxSpeed((Long) val_peek(0).obj, val_peek(1).sval);
                                  else if (val_peek(2).sval.matches("((average|avg)-speed)|((AVERAGE|AVG)-SPEED)"))
                                     yyval.obj=Pred.AvgSpeed((Long) val_peek(0).obj, val_peek(1).sval);   
                                  else {
                                      yyval.obj=Pred.FALSE(); 
                                      yyerror("Unknown identifier '"+val_peek(2).sval+"'"); 
                                 }  
                              }
break;
case 23:
//#line 113 "filters.y"
{  if (val_peek(2).sval.matches("ident|IDENT")) 
                                      yyval.obj=Pred.Ident(val_peek(0).sval); 
                                 else if (val_peek(2).sval.matches("path|PATH"))
                                      yyval.obj=Pred.Path(val_peek(0).sval);
                                 else if (val_peek(2).sval.matches("source|SOURCE")) 
                                      yyval.obj=Pred.Source(val_peek(0).sval); 
                                 else if (val_peek(2).sval.matches("symbol|SYMBOL")) 
                                      yyval.obj=Pred.AprsSym(val_peek(0).sval);      
                                 else {
                                      yyval.obj=Pred.FALSE(); 
                                      yyerror("Tried to match with unknown element '"+val_peek(2).sval+"'"); 
                                 }
                              }
break;
case 24:
//#line 127 "filters.y"
{  if (predicates.get(val_peek(0).sval) != null) 
                                      yyval.obj=predicates.get(val_peek(0).sval);
                                 else {
                                      yyval.obj=Pred.FALSE(); 
                                      yyerror("Unknown identifier '"+val_peek(0).sval+"'"); 
                                 } 
                              }
break;
case 25:
//#line 135 "filters.y"
{ yyval.obj=Pred.Tag(val_peek(0).sval); }
break;
case 26:
//#line 141 "filters.y"
{ action.merge((Action) val_peek(0).obj); }
break;
case 27:
//#line 143 "filters.y"
{ action=(Action) val_peek(0).obj; }
break;
case 28:
//#line 147 "filters.y"
{ if (val_peek(2).sval.matches("STYLE|style")) 
                                   yyval.obj=new Action(false,false,false,false,false,val_peek(0).sval,null,-1,-1);
                                else if (val_peek(2).sval.matches("ICON|icon"))
                                   yyval.obj=new Action(false,false,false,false,false,"",val_peek(0).sval,-1,-1);
                                else {
                                   yyval.obj=new Action(false,false,false,false,false,"",null,-1,-1);
                                   yyerror("Unknown identifier '"+val_peek(2).sval+"'"); 
                                }
                              }
break;
case 29:
//#line 157 "filters.y"
{ if (val_peek(2).sval.matches("trail-time"))
                                   yyval.obj = new  Action(false,false,false,false,false,"",null, (long) val_peek(0).obj, -1);
                                else if (val_peek(2).sval.matches("trail-(len|length)"))
                                   yyval.obj = new  Action(false,false,false,false,false,"",null, -1, (long) val_peek(0).obj);  
                                else {
                                   yyval.obj=new Action(false,false,false,false,false,"",null,-1,-1);
                                   yyerror("Unknown identifier '"+val_peek(2).sval+"'"); 
                                }  
                              }
break;
case 30:
//#line 167 "filters.y"
{ yyval.obj=new Action( 
                                   val_peek(0).sval.matches("hide-ident"), val_peek(0).sval.matches("hide-trail"),
                                   val_peek(0).sval.matches("hide-all"), val_peek(0).sval.matches("show-path"),
                                   val_peek(0).sval.matches("set-public"), "", null, -1, -1);
                                   
                                if (!val_peek(0).sval.matches("(hide-(ident|all|trail))|show-path|set-public"))
                                   yyerror("Unknown identifier '"+val_peek(0).sval+"'"); 
                              }
break;
case 32:
//#line 184 "filters.y"
{ if (val_peek(0).obj != null) 
                                 { tagrules.add((TagRule)val_peek(0).obj); }
                             }
break;
case 33:
//#line 187 "filters.y"
{ tagrules = new TagRuleSet();  }
break;
case 34:
//#line 192 "filters.y"
{ yyval.obj = new TagRule((Pred) val_peek(5).obj, tagaction); }
break;
case 35:
//#line 193 "filters.y"
{ yyval.obj = null; }
break;
case 36:
//#line 198 "filters.y"
{ tagaction.add(val_peek(0).sval); }
break;
case 37:
//#line 199 "filters.y"
{ tagaction=new LinkedList<String>(); tagaction.add(val_peek(0).sval); }
break;
//#line 671 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
