// This is a generated file. Not intended for manual editing.
package com.shape.idea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.shape.idea.psi.ShapeTypes.*;
import static com.shape.idea.parser.ShapeParsingUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ShapeParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ASSIGN_STATEMENT) {
      r = AssignStatement(b, 0);
    }
    else if (t == ATTR_IDENT_VALUE) {
      r = AttrIdentValue(b, 0);
    }
    else if (t == ATTR_KEY) {
      r = AttrKey(b, 0);
    }
    else if (t == ATTR_STR_VALUE) {
      r = AttrStrValue(b, 0);
    }
    else if (t == ATTR_VALUE) {
      r = AttrValue(b, 0);
    }
    else if (t == ATTRIBUTE) {
      r = Attribute(b, 0);
    }
    else if (t == ATTRIBUTE_BLOCK) {
      r = AttributeBlock(b, 0);
    }
    else if (t == ATTRIBUTE_PAIR) {
      r = AttributePair(b, 0);
    }
    else if (t == BREAK_STATEMENT) {
      r = BreakStatement(b, 0);
    }
    else if (t == CLASS_NAME) {
      r = ClassName(b, 0);
    }
    else if (t == COLOR_CODE) {
      r = ColorCode(b, 0);
    }
    else if (t == CONTINUE_STATEMENT) {
      r = ContinueStatement(b, 0);
    }
    else if (t == DIMENSION) {
      r = Dimension(b, 0);
    }
    else if (t == DO_STATEMENT) {
      r = DoStatement(b, 0);
    }
    else if (t == EXPRESSION) {
      r = Expression(b, 0);
    }
    else if (t == FOR_STATEMENT) {
      r = ForStatement(b, 0);
    }
    else if (t == ID_DEFINITION) {
      r = IdDefinition(b, 0);
    }
    else if (t == IF_STATEMENT) {
      r = IfStatement(b, 0);
    }
    else if (t == IMPORT_STATEMENT) {
      r = ImportStatement(b, 0);
    }
    else if (t == LOGICAL_EXPR) {
      r = LogicalExpr(b, 0);
    }
    else if (t == NORMAL_EXPR) {
      r = NormalExpr(b, 0);
    }
    else if (t == NUMERIC_EXPR) {
      r = NumericExpr(b, 0);
    }
    else if (t == PACKAGE_NAME) {
      r = PackageName(b, 0);
    }
    else if (t == PARAMETER) {
      r = Parameter(b, 0);
    }
    else if (t == POSTFIX_OPERATOR) {
      r = PostfixOperator(b, 0);
    }
    else if (t == PREFIX_OPERATOR) {
      r = PrefixOperator(b, 0);
    }
    else if (t == RESOURCE_REFERENCE) {
      r = ResourceReference(b, 0);
    }
    else if (t == RETURN_STATEMENT) {
      r = ReturnStatement(b, 0);
    }
    else if (t == ROOT_VIEW) {
      r = RootView(b, 0);
    }
    else if (t == SELECTOR) {
      r = Selector(b, 0);
    }
    else if (t == SINGLE_EXPR) {
      r = SingleExpr(b, 0);
    }
    else if (t == STATE_ATTRIBUTE) {
      r = StateAttribute(b, 0);
    }
    else if (t == STATEMENT) {
      r = Statement(b, 0);
    }
    else if (t == STATEMENT_BLOCK) {
      r = StatementBlock(b, 0);
    }
    else if (t == STYLE_REFERENCE) {
      r = StyleReference(b, 0);
    }
    else if (t == STYLE_STATEMENT) {
      r = StyleStatement(b, 0);
    }
    else if (t == SWITCH_STATEMENT) {
      r = SwitchStatement(b, 0);
    }
    else if (t == TOP_LEVEL_STATEMENTS) {
      r = TopLevelStatements(b, 0);
    }
    else if (t == TRY_STATEMENT) {
      r = TryStatement(b, 0);
    }
    else if (t == TYPE) {
      r = Type(b, 0);
    }
    else if (t == TYPE_CASTING_EXPR) {
      r = TypeCastingExpr(b, 0);
    }
    else if (t == TYPE_SPECIFIER) {
      r = TypeSpecifier(b, 0);
    }
    else if (t == USE_BLOCK) {
      r = UseBlock(b, 0);
    }
    else if (t == USE_STATEMENT) {
      r = UseStatement(b, 0);
    }
    else if (t == VARIABLE_DECLARATION) {
      r = VariableDeclaration(b, 0);
    }
    else if (t == VARIABLE_NAME) {
      r = VariableName(b, 0);
    }
    else if (t == VIEW) {
      r = View(b, 0);
    }
    else if (t == VIEW_ATTRIBUTE_BLOCK) {
      r = ViewAttributeBlock(b, 0);
    }
    else if (t == VIEW_BLOCK) {
      r = ViewBlock(b, 0);
    }
    else if (t == VIEW_NAME) {
      r = ViewName(b, 0);
    }
    else if (t == VIEW_RECOVER) {
      r = ViewRecover(b, 0);
    }
    else if (t == WHILE_STATEMENT) {
      r = WhileStatement(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return File(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ROOT_VIEW, VIEW),
  };

  /* ********************************************************** */
  // VariableName '=' Expression
  public static boolean AssignStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = VariableName(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    p = r; // pin = 2
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, ASSIGN_STATEMENT, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean AttrIdentValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrIdentValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ATTR_IDENT_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean AttrKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrKey")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ATTR_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // !('}' | AttrKey)
  static boolean AttrRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !AttrRecover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // '}' | AttrKey
  private static boolean AttrRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = AttrKey(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // str
  public static boolean AttrStrValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrStrValue")) return false;
    if (!nextTokenIs(b, STR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STR);
    exit_section_(b, m, ATTR_STR_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // Dimension | ResourceReference | ColorCode | AttrStrValue | AttrIdentValue | integer | floati
  public static boolean AttrValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttrValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<attr value>");
    r = Dimension(b, l + 1);
    if (!r) r = ResourceReference(b, l + 1);
    if (!r) r = ColorCode(b, l + 1);
    if (!r) r = AttrStrValue(b, l + 1);
    if (!r) r = AttrIdentValue(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, FLOATI);
    exit_section_(b, l, m, ATTR_VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AttributePair | StateAttribute
  public static boolean Attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributePair(b, l + 1);
    if (!r) r = StateAttribute(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // '{' ('}' | Attributes '}')
  public static boolean AttributeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && AttributeBlock_1(b, l + 1);
    exit_section_(b, l, m, ATTRIBUTE_BLOCK, r, p, null);
    return r || p;
  }

  // '}' | Attributes '}'
  private static boolean AttributeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = AttributeBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Attributes '}'
  private static boolean AttributeBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeBlock_1_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = Attributes(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // AttrKey ':' AttrValue
  public static boolean AttributePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributePair")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = AttrKey(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && AttrValue(b, l + 1) && r;
    exit_section_(b, l, m, ATTRIBUTE_PAIR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<SemicolonListOf Attribute>>
  static boolean Attributes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = SemicolonListOf(b, l + 1, Attribute_parser_);
    exit_section_(b, l, m, null, r, false, AttrRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // break
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // PackageName
  public static boolean ClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PackageName(b, l + 1);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // view_id_name
  public static boolean ColorCode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ColorCode")) return false;
    if (!nextTokenIs(b, VIEW_ID_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VIEW_ID_NAME);
    exit_section_(b, m, COLOR_CODE, r);
    return r;
  }

  /* ********************************************************** */
  // <<param>> { ',' <<param>> }* ','?
  static boolean CommaListOf(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "CommaListOf")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && CommaListOf_1(b, l + 1, _param);
    r = r && CommaListOf_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { ',' <<param>> }*
  private static boolean CommaListOf_1(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "CommaListOf_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!CommaListOf_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "CommaListOf_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' <<param>>
  private static boolean CommaListOf_1_0(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "CommaListOf_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean CommaListOf_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommaListOf_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // continue
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (integer | floati) (dp | sp | px | '%')
  public static boolean Dimension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dimension")) return false;
    if (!nextTokenIs(b, "<dimension>", FLOATI, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<dimension>");
    r = Dimension_0(b, l + 1);
    r = r && Dimension_1(b, l + 1);
    exit_section_(b, l, m, DIMENSION, r, false, null);
    return r;
  }

  // integer | floati
  private static boolean Dimension_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dimension_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, FLOATI);
    exit_section_(b, m, null, r);
    return r;
  }

  // dp | sp | px | '%'
  private static boolean Dimension_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dimension_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DP);
    if (!r) r = consumeToken(b, SP);
    if (!r) r = consumeToken(b, PX);
    if (!r) r = consumeToken(b, MOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // do Statement while '(' Expression ')'
  public static boolean DoStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoStatement")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && Statement(b, l + 1);
    r = r && consumeToken(b, WHILE);
    r = r && consumeToken(b, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, DO_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // NumericExpr
  // //  | ConditionalExpr
  //   | LogicalExpr
  // //  | BitExpr
  //   | TypeCastingExpr
  // //  | CreatingExpr
  // //  | LiteralExpr
  //   | null
  //   | super
  //   | this
  //   | identifier
  //   | new // TODO: 하세여
  //   | SingleExpr (
  //       ('[' Expression ']')
  //     | ('.' Expression)
  //     | (',' Expression)
  //     | (instanceof ClassName)
  //   )
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = NumericExpr(b, l + 1);
    if (!r) r = LogicalExpr(b, l + 1);
    if (!r) r = TypeCastingExpr(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, SUPER);
    if (!r) r = consumeToken(b, THIS);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NEW);
    if (!r) r = Expression_8(b, l + 1);
    exit_section_(b, l, m, EXPRESSION, r, false, null);
    return r;
  }

  // SingleExpr (
  //       ('[' Expression ']')
  //     | ('.' Expression)
  //     | (',' Expression)
  //     | (instanceof ClassName)
  //   )
  private static boolean Expression_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SingleExpr(b, l + 1);
    r = r && Expression_8_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('[' Expression ']')
  //     | ('.' Expression)
  //     | (',' Expression)
  //     | (instanceof ClassName)
  private static boolean Expression_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression_8_1_0(b, l + 1);
    if (!r) r = Expression_8_1_1(b, l + 1);
    if (!r) r = Expression_8_1_2(b, l + 1);
    if (!r) r = Expression_8_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' Expression ']'
  private static boolean Expression_8_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // '.' Expression
  private static boolean Expression_8_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' Expression
  private static boolean Expression_8_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // instanceof ClassName
  private static boolean Expression_8_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_8_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSTANCEOF);
    r = r && ClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TopLevelStatements*
  static boolean File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TopLevelStatements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "File", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // for '(' [VariableDeclaration | Expression] ';'
  //     Expression? ';'
  //     Expression? ')' Statement
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && consumeToken(b, LPAREN);
    r = r && ForStatement_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForStatement_4(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForStatement_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // [VariableDeclaration | Expression]
  private static boolean ForStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2")) return false;
    ForStatement_2_0(b, l + 1);
    return true;
  }

  // VariableDeclaration | Expression
  private static boolean ForStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration(b, l + 1);
    if (!r) r = Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression?
  private static boolean ForStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_4")) return false;
    Expression(b, l + 1);
    return true;
  }

  // Expression?
  private static boolean ForStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_6")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // view_id_name
  public static boolean IdDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IdDefinition")) return false;
    if (!nextTokenIs(b, VIEW_ID_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VIEW_ID_NAME);
    exit_section_(b, m, ID_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // if '(' Expression ')' Statement [ else Statement ]
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && consumeToken(b, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    r = r && IfStatement_5(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // [ else Statement ]
  private static boolean IfStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_5")) return false;
    IfStatement_5_0(b, l + 1);
    return true;
  }

  // else Statement
  private static boolean IfStatement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import static? ClassName ['.' '*']
  public static boolean ImportStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, IMPORT);
    p = r; // pin = 1
    r = r && report_error_(b, ImportStatement_1(b, l + 1));
    r = p && report_error_(b, ClassName(b, l + 1)) && r;
    r = p && ImportStatement_3(b, l + 1) && r;
    exit_section_(b, l, m, IMPORT_STATEMENT, r, p, null);
    return r || p;
  }

  // static?
  private static boolean ImportStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_1")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // ['.' '*']
  private static boolean ImportStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_3")) return false;
    ImportStatement_3_0(b, l + 1);
    return true;
  }

  // '.' '*'
  private static boolean ImportStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && consumeToken(b, MUL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('!' Expression)
  //   | ( SingleExpr "?" Expression ":" Expression )
  //   | ( SingleExpr "??" Expression )
  //   | true
  //   | false
  public static boolean LogicalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<logical expr>");
    r = LogicalExpr_0(b, l + 1);
    if (!r) r = LogicalExpr_1(b, l + 1);
    if (!r) r = LogicalExpr_2(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, LOGICAL_EXPR, r, false, null);
    return r;
  }

  // '!' Expression
  private static boolean LogicalExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SingleExpr "?" Expression ":" Expression
  private static boolean LogicalExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SingleExpr(b, l + 1);
    r = r && consumeToken(b, QUESTION_MARK);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SingleExpr "??" Expression
  private static boolean LogicalExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalExpr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SingleExpr(b, l + 1);
    r = r && consumeToken(b, NOTNULL);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SingleExpr ('+'|'+='|'-'|'-='|'*'|'*='|'/'|'/='|'%'|'%=') SingleExpr
  public static boolean NormalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NormalExpr")) return false;
    if (!nextTokenIs(b, "<normal expr>", LPAREN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<normal expr>");
    r = SingleExpr(b, l + 1);
    r = r && NormalExpr_1(b, l + 1);
    r = r && SingleExpr(b, l + 1);
    exit_section_(b, l, m, NORMAL_EXPR, r, false, null);
    return r;
  }

  // '+'|'+='|'-'|'-='|'*'|'*='|'/'|'/='|'%'|'%='
  private static boolean NormalExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NormalExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, QUOTIENT);
    if (!r) r = consumeToken(b, QUOTIENT_ASSIGN);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, MOD_ASSIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PrefixOperator
  //   | PostfixOperator
  //   | NormalExpr
  public static boolean NumericExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<numeric expr>");
    r = PrefixOperator(b, l + 1);
    if (!r) r = PostfixOperator(b, l + 1);
    if (!r) r = NormalExpr(b, l + 1);
    exit_section_(b, l, m, NUMERIC_EXPR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ImportStatement
  //   | UseStatement
  //   | StyleStatement
  //   | RootView
  static boolean OneOfStatements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OneOfStatements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportStatement(b, l + 1);
    if (!r) r = UseStatement(b, l + 1);
    if (!r) r = StyleStatement(b, l + 1);
    if (!r) r = RootView(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier dot_head_name*
  public static boolean PackageName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackageName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && PackageName_1(b, l + 1);
    exit_section_(b, l, m, PACKAGE_NAME, r, p, null);
    return r || p;
  }

  // dot_head_name*
  private static boolean PackageName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackageName_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, DOT_HEAD_NAME)) break;
      if (!empty_element_parsed_guard_(b, "PackageName_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // TypeSpecifier VariableName
  public static boolean Parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter>");
    r = TypeSpecifier(b, l + 1);
    r = r && VariableName(b, l + 1);
    exit_section_(b, l, m, PARAMETER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<CommaListOf Parameter>>
  static boolean Parameters(PsiBuilder b, int l) {
    return CommaListOf(b, l + 1, Parameter_parser_);
  }

  /* ********************************************************** */
  // SingleExpr('++'|'--')
  public static boolean PostfixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PostfixOperator")) return false;
    if (!nextTokenIs(b, "<postfix operator>", LPAREN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<postfix operator>");
    r = SingleExpr(b, l + 1);
    r = r && PostfixOperator_1(b, l + 1);
    exit_section_(b, l, m, POSTFIX_OPERATOR, r, false, null);
    return r;
  }

  // '++'|'--'
  private static boolean PostfixOperator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PostfixOperator_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('++'|'--'|'-') Expression
  public static boolean PrefixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<prefix operator>");
    r = PrefixOperator_0(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, PREFIX_OPERATOR, r, false, null);
    return r;
  }

  // '++'|'--'|'-'
  private static boolean PrefixOperator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixOperator_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '@' identifier '/' identifier
  public static boolean ResourceReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceReference")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, QUOTIENT);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, RESOURCE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // return Expression
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ViewName {StyleReference | IdDefinition }* ViewAttributeBlock ViewBlock?
  public static boolean RootView(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RootView")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ViewName(b, l + 1);
    r = r && RootView_1(b, l + 1);
    r = r && ViewAttributeBlock(b, l + 1);
    p = r; // pin = 3
    r = r && RootView_3(b, l + 1);
    exit_section_(b, l, m, ROOT_VIEW, r, p, null);
    return r || p;
  }

  // {StyleReference | IdDefinition }*
  private static boolean RootView_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RootView_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RootView_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RootView_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // StyleReference | IdDefinition
  private static boolean RootView_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RootView_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StyleReference(b, l + 1);
    if (!r) r = IdDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ViewBlock?
  private static boolean RootView_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RootView_3")) return false;
    ViewBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '*'
  public static boolean Selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector")) return false;
    if (!nextTokenIs(b, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    exit_section_(b, m, SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // <<param>> { semi <<param>> }* semi?
  static boolean SemicolonListOf(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "SemicolonListOf")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && SemicolonListOf_1(b, l + 1, _param);
    r = r && SemicolonListOf_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { semi <<param>> }*
  private static boolean SemicolonListOf_1(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "SemicolonListOf_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SemicolonListOf_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "SemicolonListOf_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // semi <<param>>
  private static boolean SemicolonListOf_1_0(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "SemicolonListOf_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean SemicolonListOf_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SemicolonListOf_2")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' NumericExpr ')'
  //     | TypeCastingExpr
  //     | identifier
  public static boolean SingleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleExpr")) return false;
    if (!nextTokenIs(b, "<single expr>", LPAREN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<single expr>");
    r = SingleExpr_0(b, l + 1);
    if (!r) r = TypeCastingExpr(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, SINGLE_EXPR, r, false, null);
    return r;
  }

  // '(' NumericExpr ')'
  private static boolean SingleExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && NumericExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AssignStatement | VariableName
  static boolean SingleVarDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleVarDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignStatement(b, l + 1);
    if (!r) r = VariableName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AttrKey
  public static boolean StateAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StateAttribute")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttrKey(b, l + 1);
    exit_section_(b, m, STATE_ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // StatementBlock
  //   | IfStatement
  //   | DoStatement
  //   | WhileStatement
  //   | ForStatement
  //   | TryStatement
  //   | SwitchStatement
  //   | ReturnStatement
  //   | BreakStatement
  //   | ContinueStatement
  //   | AssignStatement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = StatementBlock(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = DoStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = ForStatement(b, l + 1);
    if (!r) r = TryStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = AssignStatement(b, l + 1);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<consumeBlock>> | '{' ('}' | (<<withOff Statements "BLOCK?" "PAR">> | (!() Statements)) '}')
  public static boolean StatementBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement block>");
    r = consumeBlock(b, l + 1);
    if (!r) r = StatementBlock_1(b, l + 1);
    exit_section_(b, l, m, STATEMENT_BLOCK, r, false, null);
    return r;
  }

  // '{' ('}' | (<<withOff Statements "BLOCK?" "PAR">> | (!() Statements)) '}')
  private static boolean StatementBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && StatementBlock_1_1(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // '}' | (<<withOff Statements "BLOCK?" "PAR">> | (!() Statements)) '}'
  private static boolean StatementBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = StatementBlock_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<withOff Statements "BLOCK?" "PAR">> | (!() Statements)) '}'
  private static boolean StatementBlock_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_1_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = StatementBlock_1_1_1_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // <<withOff Statements "BLOCK?" "PAR">> | (!() Statements)
  private static boolean StatementBlock_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withOff(b, l + 1, Statements_parser_, "BLOCK?", "PAR");
    if (!r) r = StatementBlock_1_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !() Statements
  private static boolean StatementBlock_1_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_1_1_0_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = StatementBlock_1_1_1_0_1_0(b, l + 1);
    p = r; // pin = 1
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // !()
  private static boolean StatementBlock_1_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !StatementBlock_1_1_1_0_1_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // ()
  private static boolean StatementBlock_1_1_1_0_1_0_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // !(identifier | '!' | '!=' | '%' | '%=' | '&&' | '&' | '&=' | '&^' | '&^=' | '(' | '*' | '*='
  //     | '+' | '++' | '+=' | '-' | '--' | '-=' | '.' | '/' | '/=' | ':' | ';' | '<' | '<<' | '<<=' | '<=' | '=' | '==' | '>'
  //     | '>=' | '>>' | '>>=' | '[' | '^' | '^=' | '{' | '|' | '|=' | '||' | '}' | "??" | null | true | false | boolean
  //     | break | byte | case | char | continue | do | double | default | else | finally | float | for
  //     | import | if | instanceof |  int | long | new | style | short | switch | return | while
  //     | integer | hex | oct | decimali | floati | str )
  static boolean StatementRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !StatementRecover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // identifier | '!' | '!=' | '%' | '%=' | '&&' | '&' | '&=' | '&^' | '&^=' | '(' | '*' | '*='
  //     | '+' | '++' | '+=' | '-' | '--' | '-=' | '.' | '/' | '/=' | ':' | ';' | '<' | '<<' | '<<=' | '<=' | '=' | '==' | '>'
  //     | '>=' | '>>' | '>>=' | '[' | '^' | '^=' | '{' | '|' | '|=' | '||' | '}' | "??" | null | true | false | boolean
  //     | break | byte | case | char | continue | do | double | default | else | finally | float | for
  //     | import | if | instanceof |  int | long | new | style | short | switch | return | while
  //     | integer | hex | oct | decimali | floati | str
  private static boolean StatementRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, MOD_ASSIGN);
    if (!r) r = consumeToken(b, COND_AND);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, BIT_AND_ASSIGN);
    if (!r) r = consumeToken(b, BIT_CLEAR);
    if (!r) r = consumeToken(b, BIT_CLEAR_ASSIGN);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, QUOTIENT);
    if (!r) r = consumeToken(b, QUOTIENT_ASSIGN);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_LEFT_ASSIGN);
    if (!r) r = consumeToken(b, LTE);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GTE);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT_ASSIGN);
    if (!r) r = consumeToken(b, LBRACK);
    if (!r) r = consumeToken(b, BIT_XOR);
    if (!r) r = consumeToken(b, BIT_XOR_ASSIGN);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, BIT_OR);
    if (!r) r = consumeToken(b, BIT_OR_ASSIGN);
    if (!r) r = consumeToken(b, COND_OR);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, NOTNULL);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, DO);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, DEFAULT);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, FINALLY);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, INSTANCEOF);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, NEW);
    if (!r) r = consumeToken(b, STYLE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, SWITCH);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, WHILE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = consumeToken(b, OCT);
    if (!r) r = consumeToken(b, DECIMALI);
    if (!r) r = consumeToken(b, FLOATI);
    if (!r) r = consumeToken(b, STR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Statement (semi|&'}')
  static boolean StatementWithSemi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = Statement(b, l + 1);
    p = r; // pin = 1
    r = r && StatementWithSemi_1(b, l + 1);
    exit_section_(b, l, m, null, r, p, StatementRecover_parser_);
    return r || p;
  }

  // semi|&'}'
  private static boolean StatementWithSemi_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    if (!r) r = StatementWithSemi_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean StatementWithSemi_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, RBRACE);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // StatementWithSemi*
  static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    int c = current_position_(b);
    while (true) {
      if (!StatementWithSemi(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statements", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // dot_head_name
  public static boolean StyleReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StyleReference")) return false;
    if (!nextTokenIs(b, DOT_HEAD_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_HEAD_NAME);
    exit_section_(b, m, STYLE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // style identifier ['(' Selector ')'] AttributeBlock
  public static boolean StyleStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StyleStatement")) return false;
    if (!nextTokenIs(b, STYLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, STYLE, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, StyleStatement_2(b, l + 1));
    r = p && AttributeBlock(b, l + 1) && r;
    exit_section_(b, l, m, STYLE_STATEMENT, r, p, null);
    return r || p;
  }

  // ['(' Selector ')']
  private static boolean StyleStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StyleStatement_2")) return false;
    StyleStatement_2_0(b, l + 1);
    return true;
  }

  // '(' Selector ')'
  private static boolean StyleStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StyleStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Selector(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // switch '(' Expression ')' '{'
  //     { case Expression ':' Statement }*
  //     [ default Expression ':' Statement ]
  //     '}'
  public static boolean SwitchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && consumeToken(b, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && consumeToken(b, LBRACE);
    r = r && SwitchStatement_5(b, l + 1);
    r = r && SwitchStatement_6(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // { case Expression ':' Statement }*
  private static boolean SwitchStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SwitchStatement_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchStatement_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // case Expression ':' Statement
  private static boolean SwitchStatement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ default Expression ':' Statement ]
  private static boolean SwitchStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_6")) return false;
    SwitchStatement_6_0(b, l + 1);
    return true;
  }

  // default Expression ':' Statement
  private static boolean SwitchStatement_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OneOfStatements semi
  public static boolean TopLevelStatements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelStatements")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<top level statements>");
    r = OneOfStatements(b, l + 1);
    p = r; // pin = 1
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, TOP_LEVEL_STATEMENTS, r, p, TopLevelStatementsRecover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // !( import | ';' | use | style | identifier )
  static boolean TopLevelStatementsRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelStatementsRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !TopLevelStatementsRecover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // import | ';' | use | style | identifier
  private static boolean TopLevelStatementsRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelStatementsRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, USE);
    if (!r) r = consumeToken(b, STYLE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // try Statement { catch '(' Parameters ')' Statement }* [finally Statement]
  public static boolean TryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && Statement(b, l + 1);
    r = r && TryStatement_2(b, l + 1);
    r = r && TryStatement_3(b, l + 1);
    exit_section_(b, m, TRY_STATEMENT, r);
    return r;
  }

  // { catch '(' Parameters ')' Statement }*
  private static boolean TryStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TryStatement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TryStatement_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // catch '(' Parameters ')' Statement
  private static boolean TryStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && consumeToken(b, LPAREN);
    r = r && Parameters(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [finally Statement]
  private static boolean TryStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_3")) return false;
    TryStatement_3_0(b, l + 1);
    return true;
  }

  // finally Statement
  private static boolean TryStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FINALLY);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TypeSpecifier [ '[' ']' | '<' Type '>' ]
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type>");
    r = TypeSpecifier(b, l + 1);
    r = r && Type_1(b, l + 1);
    exit_section_(b, l, m, TYPE, r, false, null);
    return r;
  }

  // [ '[' ']' | '<' Type '>' ]
  private static boolean Type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1")) return false;
    Type_1_0(b, l + 1);
    return true;
  }

  // '[' ']' | '<' Type '>'
  private static boolean Type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type_1_0_0(b, l + 1);
    if (!r) r = Type_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' ']'
  private static boolean Type_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' Type '>'
  private static boolean Type_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' TypeSpecifier ')' Expression
  public static boolean TypeCastingExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeCastingExpr")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && TypeSpecifier(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, TYPE_CASTING_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // boolean
  //   | byte
  //   | char
  //   | short
  //   | int
  //   | float
  //   | long
  //   | double
  //   | ClassName
  public static boolean TypeSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSpecifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type specifier>");
    r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = ClassName(b, l + 1);
    exit_section_(b, l, m, TYPE_SPECIFIER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' ('}' | VariableDeclarations  '}')
  public static boolean UseBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UseBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && UseBlock_1(b, l + 1);
    exit_section_(b, m, USE_BLOCK, r);
    return r;
  }

  // '}' | VariableDeclarations  '}'
  private static boolean UseBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UseBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = UseBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VariableDeclarations  '}'
  private static boolean UseBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UseBlock_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclarations(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use (VariableDeclaration | UseBlock)
  public static boolean UseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UseStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, USE);
    p = r; // pin = 1
    r = r && UseStatement_1(b, l + 1);
    exit_section_(b, l, m, USE_STATEMENT, r, p, null);
    return r || p;
  }

  // VariableDeclaration | UseBlock
  private static boolean UseStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UseStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration(b, l + 1);
    if (!r) r = UseBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Type <<CommaListOf SingleVarDeclaration>>
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable declaration>");
    r = Type(b, l + 1);
    r = r && CommaListOf(b, l + 1, SingleVarDeclaration_parser_);
    exit_section_(b, l, m, VARIABLE_DECLARATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<SemicolonListOf VariableDeclaration>>
  static boolean VariableDeclarations(PsiBuilder b, int l) {
    return SemicolonListOf(b, l + 1, VariableDeclaration_parser_);
  }

  /* ********************************************************** */
  // identifier
  public static boolean VariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // ViewName {StyleReference | IdDefinition }* ViewAttributeBlock ViewBlock?
  public static boolean View(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "View")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ViewName(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, View_1(b, l + 1));
    r = p && report_error_(b, ViewAttributeBlock(b, l + 1)) && r;
    r = p && View_3(b, l + 1) && r;
    exit_section_(b, l, m, VIEW, r, p, null);
    return r || p;
  }

  // {StyleReference | IdDefinition }*
  private static boolean View_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "View_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!View_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "View_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // StyleReference | IdDefinition
  private static boolean View_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "View_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StyleReference(b, l + 1);
    if (!r) r = IdDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ViewBlock?
  private static boolean View_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "View_3")) return false;
    ViewBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' (')' | Attribute { attrDelimiter Attribute }* attrDelimiter? ')')
  public static boolean ViewAttributeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ViewAttributeBlock_1(b, l + 1);
    exit_section_(b, m, VIEW_ATTRIBUTE_BLOCK, r);
    return r;
  }

  // ')' | Attribute { attrDelimiter Attribute }* attrDelimiter? ')'
  private static boolean ViewAttributeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RPAREN);
    if (!r) r = ViewAttributeBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Attribute { attrDelimiter Attribute }* attrDelimiter? ')'
  private static boolean ViewAttributeBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Attribute(b, l + 1);
    r = r && ViewAttributeBlock_1_1_1(b, l + 1);
    r = r && ViewAttributeBlock_1_1_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // { attrDelimiter Attribute }*
  private static boolean ViewAttributeBlock_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock_1_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ViewAttributeBlock_1_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ViewAttributeBlock_1_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // attrDelimiter Attribute
  private static boolean ViewAttributeBlock_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attrDelimiter(b, l + 1);
    r = r && Attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attrDelimiter?
  private static boolean ViewAttributeBlock_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewAttributeBlock_1_1_2")) return false;
    attrDelimiter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' ('}' |  Views '}')
  public static boolean ViewBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && ViewBlock_1(b, l + 1);
    exit_section_(b, l, m, VIEW_BLOCK, r, p, null);
    return r || p;
  }

  // '}' |  Views '}'
  private static boolean ViewBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = ViewBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Views '}'
  private static boolean ViewBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewBlock_1_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = Views(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ClassName
  public static boolean ViewName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassName(b, l + 1);
    exit_section_(b, m, VIEW_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // !('}' | ClassName)
  public static boolean ViewRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, "<view recover>");
    r = !ViewRecover_0(b, l + 1);
    exit_section_(b, l, m, VIEW_RECOVER, r, false, null);
    return r;
  }

  // '}' | ClassName
  private static boolean ViewRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ViewRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = ClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<SemicolonListOf View>>
  static boolean Views(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Views")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = SemicolonListOf(b, l + 1, View_parser_);
    exit_section_(b, l, m, null, r, false, ViewRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // while '(' Expression ')' Statement
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && consumeToken(b, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ',' | '<newline>'
  static boolean attrDelimiter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrDelimiter")) return false;
    if (!nextTokenIs(b, "", COMMA, SEMICOLON_SYNTHETIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON_SYNTHETIC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<newline>' | ';' | <<eof>>
  static boolean semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semi")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON_SYNTHETIC);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  final static Parser AttrRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return AttrRecover(b, l + 1);
    }
  };
  final static Parser Attribute_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return Attribute(b, l + 1);
    }
  };
  final static Parser Parameter_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return Parameter(b, l + 1);
    }
  };
  final static Parser SingleVarDeclaration_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return SingleVarDeclaration(b, l + 1);
    }
  };
  final static Parser StatementRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return StatementRecover(b, l + 1);
    }
  };
  final static Parser Statements_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return Statements(b, l + 1);
    }
  };
  final static Parser TopLevelStatementsRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return TopLevelStatementsRecover(b, l + 1);
    }
  };
  final static Parser VariableDeclaration_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return VariableDeclaration(b, l + 1);
    }
  };
  final static Parser ViewRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ViewRecover(b, l + 1);
    }
  };
  final static Parser View_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return View(b, l + 1);
    }
  };
}
