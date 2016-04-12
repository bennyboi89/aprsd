/* The following code was generated by JFlex 1.4.3 on 4/11/16 11:02 PM */

package no.polaric.aprsd.filter;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/11/16 11:02 PM from the specification file
 * <tt>filters.lex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\1\1\2\25\0\1\1\1\50\1\25\1\3\2\0\1\46"+
    "\1\24\2\60\1\57\1\57\1\60\2\55\1\0\12\56\1\0\1\60"+
    "\1\53\1\51\1\52\2\0\1\15\1\36\1\37\1\43\1\7\1\14"+
    "\1\34\1\54\1\30\2\54\1\16\1\54\1\42\1\27\1\26\1\54"+
    "\1\5\1\17\1\4\1\6\5\54\4\0\1\55\1\0\1\20\1\40"+
    "\1\41\1\45\1\12\1\23\1\35\1\54\1\33\2\54\1\21\1\54"+
    "\1\44\1\32\1\31\1\54\1\10\1\22\1\13\1\11\5\54\1\60"+
    "\1\47\2\60\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\21\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\6\11\12\1\0\1\13\1\0"+
    "\2\12\1\4\6\12\1\14\1\7\5\12\1\3\7\12"+
    "\1\5\1\15\12\12\1\16\13\12\1\17\3\12\1\20"+
    "\1\21\1\22";

  private static int [] zzUnpackAction() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df"+
    "\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\61\0\61\0\61"+
    "\0\u0405\0\u0436\0\u0467\0\61\0\61\0\365\0\u0498\0\u04c9"+
    "\0\u04fa\0\u052b\0\u055c\0\u058d\0\u05be\0\u05ef\0\u021b\0\61"+
    "\0\u024c\0\u0620\0\u0651\0\365\0\u0682\0\u06b3\0\u06e4\0\u0715"+
    "\0\u0746\0\u0777\0\61\0\61\0\u07a8\0\u07d9\0\u080a\0\u083b"+
    "\0\u086c\0\365\0\u089d\0\u08ce\0\u08ff\0\u0930\0\u0961\0\u0992"+
    "\0\u09c3\0\365\0\365\0\u09f4\0\u0a25\0\u0a56\0\u0a87\0\u0ab8"+
    "\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c\0\u0bad\0\365\0\u0bde\0\u0c0f"+
    "\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3\0\u0d04\0\u0d35\0\u0d66\0\u0d97"+
    "\0\u0dc8\0\365\0\u0df9\0\u0e2a\0\u0e5b\0\365\0\365\0\365";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\6\6\1\7\1\10\1\11"+
    "\2\6\1\12\2\6\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\6\6\1\24\1\6\1\25"+
    "\1\6\1\26\1\27\1\30\1\31\2\32\1\6\1\2"+
    "\1\33\1\34\1\35\62\0\2\3\56\0\2\4\1\0"+
    "\56\4\4\0\1\36\1\37\2\36\1\40\13\36\2\0"+
    "\20\36\6\0\3\36\6\0\20\36\2\0\20\36\6\0"+
    "\3\36\6\0\4\36\1\40\13\36\2\0\20\36\6\0"+
    "\3\36\6\0\11\36\1\41\2\36\1\42\3\36\2\0"+
    "\20\36\6\0\3\36\6\0\2\36\1\43\15\36\2\0"+
    "\14\36\1\44\3\36\6\0\3\36\6\0\5\36\1\45"+
    "\12\36\2\0\16\36\1\46\1\36\6\0\3\36\6\0"+
    "\14\36\1\42\3\36\2\0\20\36\6\0\3\36\2\0"+
    "\2\47\1\0\21\47\1\50\34\47\2\51\1\0\22\51"+
    "\1\50\33\51\4\0\1\36\1\52\1\53\15\36\2\0"+
    "\20\36\6\0\3\36\6\0\1\36\1\54\16\36\2\0"+
    "\20\36\6\0\3\36\6\0\20\36\2\0\14\36\1\55"+
    "\3\36\6\0\3\36\6\0\4\36\1\56\1\57\12\36"+
    "\2\0\20\36\6\0\3\36\6\0\4\36\1\54\13\36"+
    "\2\0\20\36\6\0\3\36\6\0\20\36\2\0\16\36"+
    "\1\60\1\36\6\0\3\36\6\0\20\36\2\0\1\36"+
    "\1\61\16\36\6\0\3\36\6\0\20\36\2\0\4\36"+
    "\1\62\13\36\6\0\3\36\54\0\1\63\57\0\1\64"+
    "\65\0\1\33\6\0\2\36\1\65\15\36\2\0\20\36"+
    "\6\0\3\36\6\0\5\36\1\66\12\36\2\0\20\36"+
    "\6\0\3\36\6\0\12\36\1\67\5\36\2\0\20\36"+
    "\6\0\3\36\6\0\15\36\1\70\2\36\2\0\20\36"+
    "\6\0\3\36\6\0\1\71\17\36\2\0\20\36\6\0"+
    "\3\36\6\0\20\36\2\0\15\36\1\72\2\36\6\0"+
    "\3\36\6\0\7\36\1\73\10\36\2\0\20\36\6\0"+
    "\3\36\6\0\20\36\2\0\17\36\1\72\6\0\3\36"+
    "\6\0\20\36\2\0\1\36\1\74\16\36\6\0\3\36"+
    "\6\0\20\36\2\0\10\36\1\75\7\36\6\0\3\36"+
    "\6\0\20\36\2\0\11\36\1\76\6\36\6\0\3\36"+
    "\6\0\20\36\2\0\4\36\1\77\13\36\6\0\3\36"+
    "\6\0\20\36\2\0\12\36\1\100\5\36\6\0\3\36"+
    "\6\0\20\36\2\0\13\36\1\101\4\36\6\0\3\36"+
    "\6\0\1\102\17\36\2\0\20\36\6\0\3\36\6\0"+
    "\7\36\1\102\10\36\2\0\20\36\6\0\3\36\6\0"+
    "\3\36\1\103\14\36\2\0\20\36\6\0\3\36\6\0"+
    "\6\36\1\103\11\36\2\0\20\36\6\0\3\36\6\0"+
    "\13\36\1\104\4\36\2\0\20\36\6\0\3\36\6\0"+
    "\16\36\1\105\1\36\2\0\20\36\6\0\3\36\6\0"+
    "\20\36\2\0\1\36\1\106\16\36\6\0\3\36\6\0"+
    "\20\36\2\0\4\36\1\107\13\36\6\0\3\36\6\0"+
    "\10\36\1\110\7\36\2\0\20\36\6\0\3\36\6\0"+
    "\12\36\1\111\5\36\2\0\20\36\6\0\3\36\6\0"+
    "\12\36\1\112\5\36\2\0\20\36\6\0\3\36\6\0"+
    "\17\36\1\113\2\0\20\36\6\0\3\36\6\0\15\36"+
    "\1\114\2\36\2\0\20\36\6\0\3\36\6\0\15\36"+
    "\1\115\2\36\2\0\20\36\6\0\3\36\6\0\3\36"+
    "\1\116\14\36\2\0\20\36\6\0\3\36\6\0\6\36"+
    "\1\116\11\36\2\0\20\36\6\0\3\36\6\0\1\117"+
    "\17\36\2\0\20\36\6\0\3\36\6\0\7\36\1\120"+
    "\10\36\2\0\20\36\6\0\3\36\6\0\20\36\2\0"+
    "\2\36\1\121\15\36\6\0\3\36\6\0\20\36\2\0"+
    "\2\36\1\122\15\36\6\0\3\36\6\0\2\36\1\123"+
    "\15\36\2\0\20\36\6\0\3\36\6\0\20\36\2\0"+
    "\5\36\1\124\12\36\6\0\3\36\6\0\20\36\2\0"+
    "\5\36\1\125\12\36\6\0\3\36\6\0\5\36\1\126"+
    "\12\36\2\0\20\36\6\0\3\36\6\0\11\36\1\127"+
    "\6\36\2\0\20\36\6\0\3\36\6\0\14\36\1\130"+
    "\3\36\2\0\20\36\6\0\3\36\6\0\12\36\1\131"+
    "\5\36\2\0\20\36\6\0\3\36\6\0\20\36\2\0"+
    "\11\36\1\132\6\36\6\0\3\36\6\0\20\36\2\0"+
    "\15\36\1\133\2\36\6\0\3\36\6\0\15\36\1\134"+
    "\2\36\2\0\20\36\6\0\3\36\6\0\20\36\2\0"+
    "\13\36\1\132\4\36\6\0\3\36\6\0\20\36\2\0"+
    "\17\36\1\135\6\0\3\36\6\0\20\36\2\0\6\36"+
    "\1\136\11\36\6\0\3\36\6\0\20\36\2\0\7\36"+
    "\1\136\10\36\6\0\3\36\6\0\3\36\1\137\14\36"+
    "\2\0\20\36\6\0\3\36\6\0\3\36\1\140\14\36"+
    "\2\0\20\36\6\0\3\36\6\0\6\36\1\137\11\36"+
    "\2\0\20\36\6\0\3\36\6\0\6\36\1\140\11\36"+
    "\2\0\20\36\6\0\3\36\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3724];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\3\11\3\1\2\11\11\1\1\0"+
    "\1\11\1\0\11\1\2\11\54\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /* store a reference to the parser object */
    private Parser yyparser;

    /* constructor taking an additional parser object */
    public Lexer(java.io.Reader r, Parser p) {
        this(r);
        this.yyparser = p;
    }
              
    public int line() {return yyline+1;}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 146) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 8: 
          { yyparser.yylval = new ParserVal((Long) Long.parseLong(yytext())); 
           return Parser.NUM;
          }
        case 19: break;
        case 14: 
          { yyparser.yylval = new ParserVal(false); 
              return Parser.BOOLEAN;
          }
        case 20: break;
        case 5: 
          { return Parser.NOT;
          }
        case 21: break;
        case 1: 
          { yyparser.yylval = new ParserVal("Unexpected/illegal character '"+ yytext()+"'"); 
             return Parser.ERROR;
          }
        case 22: break;
        case 3: 
          { return Parser.AND;
          }
        case 23: break;
        case 6: 
          { return (int) yycharat(0);
          }
        case 24: break;
        case 12: 
          { return Parser.ARROW;
          }
        case 25: break;
        case 15: 
          { return Parser.PUBLIC;
          }
        case 26: break;
        case 4: 
          { return Parser.OR;
          }
        case 27: break;
        case 10: 
          { yyparser.yylval = new ParserVal(yytext()); 
           return Parser.IDENT;
          }
        case 28: break;
        case 7: 
          { yyparser.yylval = new ParserVal(yytext());
           return Parser.RELOP;
          }
        case 29: break;
        case 11: 
          { yyparser.yylval = new ParserVal(yytext().substring(1,yytext().length()-1)); 
             return Parser.STRING;
          }
        case 30: break;
        case 16: 
          { return Parser.AUTOTAG;
          }
        case 31: break;
        case 18: 
          { return Parser.INCLUDE;
          }
        case 32: break;
        case 13: 
          { yyparser.yylval = new ParserVal(true); 
              return Parser.BOOLEAN;
          }
        case 33: break;
        case 9: 
          { return Parser.TAG;
          }
        case 34: break;
        case 2: 
          { 
          }
        case 35: break;
        case 17: 
          { return Parser.PROFILE;
          }
        case 36: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
