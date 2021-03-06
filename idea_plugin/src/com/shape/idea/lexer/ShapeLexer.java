/* The following code was generated by JFlex 1.4.3 on 15. 9. 16 오후 3:38 */


package com.shape.idea.lexer;
 
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.shape.idea.psi.ShapeTypes.*;
import static com.shape.idea.parser.ShapeParserDefinition.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 15. 9. 16 오후 3:38 from the specification file
 * <tt>/Users/vista/Dropbox/Projects/less/idea_plugin/grammar/shape.flex</tt>
 */
public class ShapeLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int MAYBE_SEMICOLON = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\1\1\0\1\3\1\2\22\0\1\3\1\44\1\25"+
    "\1\13\1\0\1\51\1\46\1\30\1\35\1\36\1\24\1\45\1\41"+
    "\1\20\1\12\1\4\1\14\7\11\1\27\1\10\1\37\1\40\1\50"+
    "\1\43\1\52\1\42\1\77\4\7\1\17\1\7\16\5\1\21\2\5"+
    "\1\16\2\5\1\33\1\26\1\34\1\47\1\5\1\0\1\62\1\22"+
    "\1\67\1\72\1\60\1\61\1\75\1\70\1\71\1\5\1\65\1\55"+
    "\1\73\1\53\1\64\1\74\1\5\1\57\1\63\1\56\1\54\1\21"+
    "\1\76\1\15\1\66\1\5\1\31\1\23\1\32\54\0\1\5\12\0"+
    "\1\5\4\0\1\5\5\0\27\5\1\0\37\5\1\0\u013f\5\31\0"+
    "\162\5\4\0\14\5\16\0\5\5\11\0\1\5\213\0\1\5\13\0"+
    "\1\5\1\0\3\5\1\0\1\5\1\0\24\5\1\0\54\5\1\0"+
    "\46\5\1\0\5\5\4\0\202\5\10\0\105\5\1\0\46\5\2\0"+
    "\2\5\6\0\20\5\41\0\46\5\2\0\1\5\7\0\47\5\110\0"+
    "\33\5\5\0\3\5\56\0\32\5\5\0\13\5\25\0\12\6\4\0"+
    "\2\5\1\0\143\5\1\0\1\5\17\0\2\5\7\0\2\5\12\6"+
    "\3\5\2\0\1\5\20\0\1\5\1\0\36\5\35\0\3\5\60\0"+
    "\46\5\13\0\1\5\u0152\0\66\5\3\0\1\5\22\0\1\5\7\0"+
    "\12\5\4\0\12\6\25\0\10\5\2\0\2\5\2\0\26\5\1\0"+
    "\7\5\1\0\1\5\3\0\4\5\3\0\1\5\36\0\2\5\1\0"+
    "\3\5\4\0\12\6\2\5\23\0\6\5\4\0\2\5\2\0\26\5"+
    "\1\0\7\5\1\0\2\5\1\0\2\5\1\0\2\5\37\0\4\5"+
    "\1\0\1\5\7\0\12\6\2\0\3\5\20\0\11\5\1\0\3\5"+
    "\1\0\26\5\1\0\7\5\1\0\2\5\1\0\5\5\3\0\1\5"+
    "\22\0\1\5\17\0\2\5\4\0\12\6\25\0\10\5\2\0\2\5"+
    "\2\0\26\5\1\0\7\5\1\0\2\5\1\0\5\5\3\0\1\5"+
    "\36\0\2\5\1\0\3\5\4\0\12\6\1\0\1\5\21\0\1\5"+
    "\1\0\6\5\3\0\3\5\1\0\4\5\3\0\2\5\1\0\1\5"+
    "\1\0\2\5\3\0\2\5\3\0\3\5\3\0\10\5\1\0\3\5"+
    "\55\0\11\6\25\0\10\5\1\0\3\5\1\0\27\5\1\0\12\5"+
    "\1\0\5\5\46\0\2\5\4\0\12\6\25\0\10\5\1\0\3\5"+
    "\1\0\27\5\1\0\12\5\1\0\5\5\3\0\1\5\40\0\1\5"+
    "\1\0\2\5\4\0\12\6\25\0\10\5\1\0\3\5\1\0\27\5"+
    "\1\0\20\5\46\0\2\5\4\0\12\6\25\0\22\5\3\0\30\5"+
    "\1\0\11\5\1\0\1\5\2\0\7\5\72\0\60\5\1\0\2\5"+
    "\14\0\7\5\11\0\12\6\47\0\2\5\1\0\1\5\2\0\2\5"+
    "\1\0\1\5\2\0\1\5\6\0\4\5\1\0\7\5\1\0\3\5"+
    "\1\0\1\5\1\0\1\5\2\0\2\5\1\0\4\5\1\0\2\5"+
    "\11\0\1\5\2\0\5\5\1\0\1\5\11\0\12\6\2\0\2\5"+
    "\42\0\1\5\37\0\12\6\26\0\10\5\1\0\42\5\35\0\4\5"+
    "\164\0\42\5\1\0\5\5\1\0\2\5\25\0\12\6\6\0\6\5"+
    "\112\0\46\5\12\0\51\5\7\0\132\5\5\0\104\5\5\0\122\5"+
    "\6\0\7\5\1\0\77\5\1\0\1\5\1\0\4\5\2\0\7\5"+
    "\1\0\1\5\1\0\4\5\2\0\47\5\1\0\1\5\1\0\4\5"+
    "\2\0\37\5\1\0\1\5\1\0\4\5\2\0\7\5\1\0\1\5"+
    "\1\0\4\5\2\0\7\5\1\0\7\5\1\0\27\5\1\0\37\5"+
    "\1\0\1\5\1\0\4\5\2\0\7\5\1\0\47\5\1\0\23\5"+
    "\16\0\11\6\56\0\125\5\14\0\u026c\5\2\0\10\5\12\0\32\5"+
    "\5\0\113\5\25\0\15\5\1\0\4\5\16\0\22\5\16\0\22\5"+
    "\16\0\15\5\1\0\3\5\17\0\64\5\43\0\1\5\4\0\1\5"+
    "\3\0\12\6\46\0\12\6\6\0\130\5\10\0\51\5\127\0\35\5"+
    "\51\0\12\6\36\5\2\0\5\5\u038b\0\154\5\224\0\234\5\4\0"+
    "\132\5\6\0\26\5\2\0\6\5\2\0\46\5\2\0\6\5\2\0"+
    "\10\5\1\0\1\5\1\0\1\5\1\0\1\5\1\0\37\5\2\0"+
    "\65\5\1\0\7\5\1\0\1\5\3\0\3\5\1\0\7\5\3\0"+
    "\4\5\2\0\6\5\4\0\15\5\5\0\3\5\1\0\7\5\164\0"+
    "\1\5\15\0\1\5\202\0\1\5\4\0\1\5\2\0\12\5\1\0"+
    "\1\5\3\0\5\5\6\0\1\5\1\0\1\5\1\0\1\5\1\0"+
    "\4\5\1\0\3\5\1\0\7\5\3\0\3\5\5\0\5\5\u0ebb\0"+
    "\2\5\52\0\5\5\5\0\2\5\4\0\126\5\6\0\3\5\1\0"+
    "\132\5\1\0\4\5\5\0\50\5\4\0\136\5\21\0\30\5\70\0"+
    "\20\5\u0200\0\u19b6\5\112\0\u51a6\5\132\0\u048d\5\u0773\0\u2ba4\5\u215c\0"+
    "\u012e\5\2\0\73\5\225\0\7\5\14\0\5\5\5\0\1\5\1\0"+
    "\12\5\1\0\15\5\1\0\5\5\1\0\1\5\1\0\2\5\1\0"+
    "\2\5\1\0\154\5\41\0\u016b\5\22\0\100\5\2\0\66\5\50\0"+
    "\14\5\164\0\5\5\1\0\207\5\23\0\12\6\7\0\32\5\6\0"+
    "\32\5\13\0\131\5\3\0\6\5\2\0\6\5\2\0\6\5\2\0"+
    "\3\5\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\6\1\11\1\5\1\12\1\13\2\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\15\5\1\37\1\40\2\41\1\40\1\42"+
    "\1\43\1\44\1\0\1\45\1\0\1\46\1\47\1\50"+
    "\1\51\1\0\1\52\1\53\3\5\1\54\1\55\1\56"+
    "\1\14\2\0\1\57\1\60\1\61\1\62\1\63\1\64"+
    "\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74"+
    "\15\5\1\75\5\5\1\76\2\5\1\77\1\100\1\101"+
    "\1\5\1\43\1\45\1\0\1\102\3\5\1\103\1\104"+
    "\1\105\1\5\1\106\1\107\6\5\1\110\7\5\1\111"+
    "\5\5\1\43\1\0\2\5\1\112\1\113\1\114\1\115"+
    "\1\5\1\116\6\5\1\117\1\5\1\120\5\5\1\121"+
    "\2\5\1\122\1\123\1\5\1\124\1\125\6\5\1\126"+
    "\1\5\1\127\1\5\1\130\2\5\1\131\1\5\1\132"+
    "\1\133\1\134\2\5\1\135\1\136\2\5\1\137";

  private static int [] zzUnpackAction() {
    int [] result = new int[206];
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
    "\0\0\0\100\0\200\0\300\0\200\0\u0100\0\u0140\0\u0180"+
    "\0\u01c0\0\u0200\0\u0240\0\u0280\0\u02c0\0\u0300\0\u0340\0\u0380"+
    "\0\u03c0\0\u0400\0\200\0\200\0\200\0\200\0\200\0\200"+
    "\0\200\0\200\0\200\0\u0440\0\u0480\0\u04c0\0\u0500\0\u0540"+
    "\0\u0580\0\u05c0\0\u0600\0\u0640\0\u0680\0\u06c0\0\u0700\0\u0740"+
    "\0\u0780\0\u07c0\0\u0800\0\u0840\0\u0880\0\u08c0\0\u0900\0\u0940"+
    "\0\u0980\0\200\0\200\0\200\0\u09c0\0\u0a00\0\u0a40\0\u0a80"+
    "\0\200\0\u0180\0\u0ac0\0\u0b00\0\200\0\u0b40\0\u0b80\0\u0bc0"+
    "\0\u0c00\0\200\0\200\0\u0c40\0\u0c80\0\u0cc0\0\200\0\200"+
    "\0\200\0\200\0\u0d00\0\u0d40\0\200\0\200\0\200\0\200"+
    "\0\200\0\200\0\200\0\u0d80\0\200\0\200\0\u0dc0\0\200"+
    "\0\200\0\u0e00\0\u0e40\0\u0e80\0\u0ec0\0\u0f00\0\u0f40\0\u0f80"+
    "\0\u0fc0\0\u1000\0\u1040\0\u1080\0\u10c0\0\u1100\0\u1140\0\u0140"+
    "\0\u1180\0\u11c0\0\u1200\0\u1240\0\u1280\0\u0140\0\u12c0\0\u1300"+
    "\0\u1340\0\u0140\0\u0140\0\u1380\0\u13c0\0\u1400\0\u1400\0\u0c00"+
    "\0\u1440\0\u1480\0\u14c0\0\200\0\200\0\200\0\u1500\0\u0140"+
    "\0\u0140\0\u1540\0\u1580\0\u15c0\0\u1600\0\u1640\0\u1680\0\u0140"+
    "\0\u16c0\0\u1700\0\u1740\0\u1780\0\u17c0\0\u1800\0\u1840\0\u0140"+
    "\0\u1880\0\u18c0\0\u1900\0\u1940\0\u1980\0\200\0\u13c0\0\u19c0"+
    "\0\u1a00\0\u0140\0\u0140\0\u0140\0\u0140\0\u1a40\0\u0140\0\u1a80"+
    "\0\u1ac0\0\u1b00\0\u1b40\0\u1b80\0\u1bc0\0\u0140\0\u1c00\0\u0140"+
    "\0\u1c40\0\u1c80\0\u1cc0\0\u1d00\0\u1d40\0\u0140\0\u1d80\0\u1dc0"+
    "\0\u0140\0\u0140\0\u1e00\0\u0140\0\u0140\0\u1e40\0\u1e80\0\u1ec0"+
    "\0\u1f00\0\u1f40\0\u1f80\0\u0140\0\u1fc0\0\u0140\0\u2000\0\u0140"+
    "\0\u2040\0\u2080\0\u0140\0\u20c0\0\u0140\0\u0140\0\u0140\0\u2100"+
    "\0\u2140\0\u0140\0\u0140\0\u2180\0\u21c0\0\u0140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[206];
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
    "\1\3\2\4\1\5\1\6\1\7\1\10\1\7\2\11"+
    "\1\12\1\13\1\14\3\7\1\15\1\7\1\16\1\17"+
    "\1\20\1\21\1\3\1\11\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\7\1\54"+
    "\3\7\1\55\1\7\1\56\1\57\1\7\1\60\1\7"+
    "\1\61\1\62\1\63\1\64\1\65\1\5\1\66\73\63"+
    "\101\0\2\4\101\0\1\67\17\0\1\70\16\0\1\71"+
    "\41\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\24\7\7\0\1\72\1\0\2\72\1\73\1\0"+
    "\1\72\2\0\1\74\7\0\1\72\30\0\1\74\10\0"+
    "\1\75\14\0\1\72\1\0\2\11\1\73\1\0\1\11"+
    "\2\0\1\74\7\0\1\11\30\0\1\74\10\0\1\75"+
    "\13\0\1\76\1\73\1\76\2\73\2\0\1\73\3\76"+
    "\1\0\2\76\4\0\1\73\23\0\24\76\6\0\1\77"+
    "\1\0\1\77\5\0\3\77\1\0\2\77\30\0\24\77"+
    "\7\0\1\72\1\0\1\72\1\100\1\73\1\0\1\100"+
    "\2\101\1\74\7\0\1\72\30\0\1\74\10\0\1\75"+
    "\26\0\1\102\22\0\1\103\41\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\4\7\1\104\4\7"+
    "\1\105\1\7\1\106\10\7\24\0\1\107\17\0\1\110"+
    "\77\0\1\111\34\0\1\21\2\0\22\21\1\112\1\113"+
    "\51\21\1\22\2\0\23\22\1\114\1\22\1\112\47\22"+
    "\42\0\1\115\100\0\1\116\77\0\1\117\77\0\1\120"+
    "\1\0\1\121\75\0\1\122\2\0\1\123\1\124\73\0"+
    "\1\125\77\0\1\126\4\0\1\127\72\0\1\130\77\0"+
    "\1\131\6\0\1\132\32\0\5\7\2\0\4\7\1\0"+
    "\2\7\4\0\1\7\23\0\1\7\1\133\3\7\1\134"+
    "\16\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\10\7\1\135\13\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\11\7\1\136"+
    "\12\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\4\7\1\137\17\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\5\7\1\140"+
    "\16\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\2\7\1\141\21\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\2\7\1\142"+
    "\4\7\1\143\1\7\1\144\4\7\1\145\5\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\3\7\1\146\11\7\1\147\3\7\1\150\1\7\1\151"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\7\7\1\152\1\7\1\153\3\7\1\154\6\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\1\155\5\7\1\156\11\7\1\157\3\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\5\7\1\160\3\7\1\161\7\7\1\162\2\7\6\0"+
    "\5\7\2\0\1\7\1\163\2\7\1\0\2\7\4\0"+
    "\1\7\23\0\24\7\6\0\5\7\2\0\4\7\1\0"+
    "\2\7\4\0\1\7\23\0\15\7\1\164\6\7\2\0"+
    "\1\64\102\0\1\67\17\0\1\70\53\0\1\67\2\0"+
    "\75\67\24\70\1\165\53\70\6\0\1\73\1\0\2\73"+
    "\2\0\1\73\2\0\1\74\7\0\1\73\30\0\1\74"+
    "\25\0\1\166\1\0\2\166\2\0\1\166\3\0\1\167"+
    "\6\0\1\166\15\0\1\167\37\0\5\76\2\0\4\76"+
    "\1\0\2\76\4\0\1\76\23\0\24\76\6\0\5\77"+
    "\2\0\4\77\1\0\2\77\4\0\1\77\23\0\24\77"+
    "\7\0\1\72\1\0\1\72\1\100\1\73\1\0\1\100"+
    "\2\0\1\74\7\0\1\72\30\0\1\74\10\0\1\75"+
    "\15\0\3\170\2\0\1\170\2\0\1\170\2\0\1\170"+
    "\4\0\1\170\30\0\3\170\4\0\1\170\2\0\1\170"+
    "\12\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\5\7\1\171\16\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\11\7\1\172\12\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\3\7\1\173\20\7\12\0\1\21\2\0\2\21"+
    "\3\0\2\21\2\0\3\21\23\0\2\21\1\0\2\21"+
    "\1\0\2\21\26\0\1\22\2\0\2\22\3\0\2\22"+
    "\3\0\3\22\22\0\2\22\1\0\2\22\1\0\2\22"+
    "\60\0\1\174\77\0\1\175\77\0\1\176\41\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\2\7"+
    "\1\177\21\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\23\7\1\200\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\5\7\1\201"+
    "\16\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\1\202\23\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\1\7\1\203\22\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\3\7\1\204\20\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\10\7\1\205\13\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\11\7\1\206\12\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\2\7\1\207\21\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\4\7\1\210\17\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\1\211\23\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\13\7\1\212\10\7\6\0\5\7\2\0\4\7\1\0"+
    "\2\7\4\0\1\7\23\0\11\7\1\213\12\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\16\7\1\214\5\7\6\0\5\7\2\0\4\7\1\0"+
    "\2\7\4\0\1\7\23\0\10\7\1\215\13\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\1\216\23\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\7\7\1\217\14\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\3\7"+
    "\1\220\4\7\1\221\13\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\21\7\1\222\2\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\6\7\1\223\15\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\1\7\1\224\22\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\16\7\1\225\5\7\1\0\4\70\1\226\17\70"+
    "\1\227\53\70\6\0\1\166\1\0\2\166\2\0\1\166"+
    "\12\0\1\166\55\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\7\7\1\230\14\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\2\7"+
    "\1\231\21\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\5\7\1\232\16\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\2\7"+
    "\1\233\21\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\22\7\1\234\1\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\5\7"+
    "\1\235\16\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\1\7\1\236\22\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\5\7"+
    "\1\237\16\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\7\7\1\240\14\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\10\7"+
    "\1\241\13\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\7\7\1\242\14\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\2\7"+
    "\1\243\21\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\4\7\1\244\17\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\3\7"+
    "\1\245\20\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\5\7\1\246\16\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\3\7"+
    "\1\247\20\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\4\7\1\250\17\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\3\7"+
    "\1\251\20\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\11\7\1\252\12\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\7\7"+
    "\1\253\14\7\6\0\5\7\2\0\4\7\1\0\1\7"+
    "\1\254\4\0\1\7\23\0\24\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\2\7\1\255"+
    "\21\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\12\7\1\256\11\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\5\7\1\257"+
    "\16\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\4\7\1\260\17\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\3\7\1\261"+
    "\20\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\5\7\1\262\16\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\2\7\1\263"+
    "\21\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\5\7\1\264\16\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\3\7\1\265"+
    "\20\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\14\7\1\266\7\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\16\7\1\267"+
    "\5\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\7\7\1\270\14\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\4\7\1\271"+
    "\17\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\1\7\1\272\22\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\2\7\1\273"+
    "\21\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\5\7\1\274\16\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\7\7\1\275"+
    "\14\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\1\276\23\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\2\7\1\277\21\7"+
    "\6\0\5\7\2\0\4\7\1\0\2\7\4\0\1\7"+
    "\23\0\15\7\1\300\6\7\6\0\5\7\2\0\4\7"+
    "\1\0\2\7\4\0\1\7\23\0\1\301\23\7\6\0"+
    "\5\7\2\0\4\7\1\0\2\7\4\0\1\7\23\0"+
    "\1\302\23\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\3\7\1\303\20\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\2\7"+
    "\1\304\21\7\6\0\5\7\2\0\4\7\1\0\2\7"+
    "\4\0\1\7\23\0\5\7\1\305\16\7\6\0\5\7"+
    "\2\0\4\7\1\0\2\7\4\0\1\7\23\0\1\306"+
    "\23\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\13\7\1\307\10\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\1\7\1\310"+
    "\22\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\14\7\1\311\7\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\3\7\1\312"+
    "\20\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\5\7\1\313\16\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\5\7\1\314"+
    "\16\7\6\0\5\7\2\0\4\7\1\0\2\7\4\0"+
    "\1\7\23\0\11\7\1\315\12\7\6\0\5\7\2\0"+
    "\4\7\1\0\2\7\4\0\1\7\23\0\6\7\1\316"+
    "\15\7\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8704];
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
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

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
    "\2\0\1\11\1\1\1\11\15\1\11\11\26\1\3\11"+
    "\4\1\1\11\1\0\1\1\1\0\1\11\3\1\1\0"+
    "\2\11\3\1\4\11\2\0\7\11\1\1\2\11\1\1"+
    "\2\11\35\1\1\0\4\1\3\11\27\1\1\11\1\0"+
    "\67\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[206];
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

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ShapeLexer(java.io.Reader in) {
    this.zzReader = in;
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
    while (i < 1324) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
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
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
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
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
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
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
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
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
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
        case 57: 
          { return SHIFT_LEFT;
          }
        case 96: break;
        case 67: 
          { return BIT_CLEAR_ASSIGN;
          }
        case 97: break;
        case 35: 
          { return BLOCK_COMMENT;
          }
        case 98: break;
        case 17: 
          { return LPAREN;
          }
        case 99: break;
        case 53: 
          { return COND_AND;
          }
        case 100: break;
        case 42: 
          { yybegin(MAYBE_SEMICOLON); return MINUS_MINUS;
          }
        case 101: break;
        case 86: 
          { return WHILE;
          }
        case 102: break;
        case 77: 
          { return TRUE;
          }
        case 103: break;
        case 50: 
          { return PLUS_ASSIGN;
          }
        case 104: break;
        case 40: 
          { yybegin(MAYBE_SEMICOLON); return VIEW_ID_NAME;
          }
        case 105: break;
        case 94: 
          { yybegin(MAYBE_SEMICOLON); return CONTINUE;
          }
        case 106: break;
        case 19: 
          { return COLON;
          }
        case 107: break;
        case 48: 
          { return EQ;
          }
        case 108: break;
        case 18: 
          { yybegin(MAYBE_SEMICOLON); return RPAREN;
          }
        case 109: break;
        case 12: 
          { yybegin(MAYBE_SEMICOLON); return STR;
          }
        case 110: break;
        case 71: 
          { return USE;
          }
        case 111: break;
        case 87: 
          { return RETURN;
          }
        case 112: break;
        case 20: 
          { return SEMICOLON;
          }
        case 113: break;
        case 90: 
          { return DOUBLE;
          }
        case 114: break;
        case 22: 
          { return QUESTION_MARK;
          }
        case 115: break;
        case 21: 
          { return COMMA;
          }
        case 116: break;
        case 8: 
          { return ID_SIGN;
          }
        case 117: break;
        case 29: 
          { return MOD;
          }
        case 118: break;
        case 64: 
          { return DP;
          }
        case 119: break;
        case 41: 
          { yybegin(MAYBE_SEMICOLON); return OCT;
          }
        case 120: break;
        case 47: 
          { return NOTNULL;
          }
        case 121: break;
        case 44: 
          { return COND_OR;
          }
        case 122: break;
        case 68: 
          { return SHIFT_LEFT_ASSIGN;
          }
        case 123: break;
        case 76: 
          { return LONG;
          }
        case 124: break;
        case 25: 
          { return PLUS;
          }
        case 125: break;
        case 1: 
          { return BAD_CHARACTER;
          }
        case 126: break;
        case 26: 
          { return BIT_AND;
          }
        case 127: break;
        case 75: 
          { return NULL;
          }
        case 128: break;
        case 52: 
          { return BIT_AND_ASSIGN;
          }
        case 129: break;
        case 28: 
          { return LT;
          }
        case 130: break;
        case 88: 
          { return SWITCH;
          }
        case 131: break;
        case 66: 
          { yybegin(MAYBE_SEMICOLON); return HEX;
          }
        case 132: break;
        case 4: 
          { return QUOTIENT;
          }
        case 133: break;
        case 6: 
          { yybegin(MAYBE_SEMICOLON); return INTEGER;
          }
        case 134: break;
        case 10: 
          { return BIT_OR;
          }
        case 135: break;
        case 43: 
          { return MINUS_ASSIGN;
          }
        case 136: break;
        case 7: 
          { return DOT;
          }
        case 137: break;
        case 93: 
          { return DEFAULT;
          }
        case 138: break;
        case 63: 
          { return DO;
          }
        case 139: break;
        case 81: 
          { yybegin(MAYBE_SEMICOLON); return BREAK;
          }
        case 140: break;
        case 80: 
          { return CHAR;
          }
        case 141: break;
        case 2: 
          { return NEWLINES;
          }
        case 142: break;
        case 83: 
          { return FALSE;
          }
        case 143: break;
        case 84: 
          { return STYLE;
          }
        case 144: break;
        case 55: 
          { return BIT_XOR_ASSIGN;
          }
        case 145: break;
        case 70: 
          { return NEW;
          }
        case 146: break;
        case 30: 
          { return GT;
          }
        case 147: break;
        case 34: 
          { return LINE_COMMENT;
          }
        case 148: break;
        case 5: 
          { yybegin(MAYBE_SEMICOLON); return IDENTIFIER;
          }
        case 149: break;
        case 73: 
          { return INT;
          }
        case 150: break;
        case 32: 
          { yybegin(YYINITIAL); yypushback(yytext().length());
          }
        case 151: break;
        case 65: 
          { return PX;
          }
        case 152: break;
        case 74: 
          { return BYTE;
          }
        case 153: break;
        case 45: 
          { return BIT_OR_ASSIGN;
          }
        case 154: break;
        case 54: 
          { return BIT_CLEAR;
          }
        case 155: break;
        case 82: 
          { return FLOAT;
          }
        case 156: break;
        case 13: 
          { return LBRACE;
          }
        case 157: break;
        case 23: 
          { return ASSIGN;
          }
        case 158: break;
        case 27: 
          { return BIT_XOR;
          }
        case 159: break;
        case 38: 
          { yybegin(MAYBE_SEMICOLON); return DECIMALI;
          }
        case 160: break;
        case 15: 
          { return LBRACK;
          }
        case 161: break;
        case 24: 
          { return NOT;
          }
        case 162: break;
        case 49: 
          { return NOT_EQ;
          }
        case 163: break;
        case 89: 
          { return IMPORT;
          }
        case 164: break;
        case 3: 
          { return WHITE_SPACE;
          }
        case 165: break;
        case 46: 
          { return MUL_ASSIGN;
          }
        case 166: break;
        case 31: 
          { return AT;
          }
        case 167: break;
        case 78: 
          { return ELSE;
          }
        case 168: break;
        case 62: 
          { return IF;
          }
        case 169: break;
        case 95: 
          { return INSTANCEOF;
          }
        case 170: break;
        case 14: 
          { yybegin(MAYBE_SEMICOLON); return RBRACE;
          }
        case 171: break;
        case 11: 
          { return MUL;
          }
        case 172: break;
        case 51: 
          { yybegin(MAYBE_SEMICOLON); return PLUS_PLUS;
          }
        case 173: break;
        case 92: 
          { return FINALLY;
          }
        case 174: break;
        case 59: 
          { return GTE;
          }
        case 175: break;
        case 16: 
          { yybegin(MAYBE_SEMICOLON); return RBRACK;
          }
        case 176: break;
        case 9: 
          { return MINUS;
          }
        case 177: break;
        case 61: 
          { return SP;
          }
        case 178: break;
        case 72: 
          { return FOR;
          }
        case 179: break;
        case 58: 
          { return MOD_ASSIGN;
          }
        case 180: break;
        case 79: 
          { return CASE;
          }
        case 181: break;
        case 39: 
          { yybegin(MAYBE_SEMICOLON); return DOT_HEAD_NAME;
          }
        case 182: break;
        case 37: 
          { yybegin(MAYBE_SEMICOLON); return FLOATI;
          }
        case 183: break;
        case 69: 
          { return SHIFT_RIGHT_ASSIGN;
          }
        case 184: break;
        case 33: 
          { yybegin(YYINITIAL);/* yypushback(yytext().length());*/ return SEMICOLON_SYNTHETIC;
          }
        case 185: break;
        case 60: 
          { return SHIFT_RIGHT;
          }
        case 186: break;
        case 85: 
          { return SHORT;
          }
        case 187: break;
        case 91: 
          { return BOOLEAN;
          }
        case 188: break;
        case 36: 
          { return QUOTIENT_ASSIGN;
          }
        case 189: break;
        case 56: 
          { return LTE;
          }
        case 190: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
