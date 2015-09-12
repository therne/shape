// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.shape.idea.psi.impl.*;

public interface ShapeTypes {

  IElementType ASSIGN_STATEMENT = new ShapeElementType("ASSIGN_STATEMENT");
  IElementType ATTRIBUTE = new ShapeElementType("ATTRIBUTE");
  IElementType ATTRIBUTE_BLOCK = new ShapeElementType("ATTRIBUTE_BLOCK");
  IElementType ATTRIBUTE_PAIR = new ShapeElementType("ATTRIBUTE_PAIR");
  IElementType ATTR_KEY = new ShapeElementType("ATTR_KEY");
  IElementType ATTR_VALUE = new ShapeElementType("ATTR_VALUE");
  IElementType BREAK_STATEMENT = new ShapeElementType("BREAK_STATEMENT");
  IElementType CLASS_NAME = new ShapeElementType("CLASS_NAME");
  IElementType CONTINUE_STATEMENT = new ShapeElementType("CONTINUE_STATEMENT");
  IElementType DIMENSION = new ShapeElementType("DIMENSION");
  IElementType DO_STATEMENT = new ShapeElementType("DO_STATEMENT");
  IElementType EXPRESSION = new ShapeElementType("EXPRESSION");
  IElementType FOR_STATEMENT = new ShapeElementType("FOR_STATEMENT");
  IElementType ID_DEFINITION = new ShapeElementType("ID_DEFINITION");
  IElementType IF_STATEMENT = new ShapeElementType("IF_STATEMENT");
  IElementType IMPORT_STATEMENT = new ShapeElementType("IMPORT_STATEMENT");
  IElementType LOGICAL_EXPR = new ShapeElementType("LOGICAL_EXPR");
  IElementType NORMAL_EXPR = new ShapeElementType("NORMAL_EXPR");
  IElementType NUMERIC_EXPR = new ShapeElementType("NUMERIC_EXPR");
  IElementType PACKAGE_NAME = new ShapeElementType("PACKAGE_NAME");
  IElementType PARAMETER = new ShapeElementType("PARAMETER");
  IElementType POSTFIX_OPERATOR = new ShapeElementType("POSTFIX_OPERATOR");
  IElementType PREFIX_OPERATOR = new ShapeElementType("PREFIX_OPERATOR");
  IElementType RESOURCE_REFERENCE = new ShapeElementType("RESOURCE_REFERENCE");
  IElementType RETURN_STATEMENT = new ShapeElementType("RETURN_STATEMENT");
  IElementType ROOT_VIEW = new ShapeElementType("ROOT_VIEW");
  IElementType SELECTOR = new ShapeElementType("SELECTOR");
  IElementType SINGLE_EXPR = new ShapeElementType("SINGLE_EXPR");
  IElementType STATEMENT = new ShapeElementType("STATEMENT");
  IElementType STATEMENT_BLOCK = new ShapeElementType("STATEMENT_BLOCK");
  IElementType STATE_ATTRIBUTE = new ShapeElementType("STATE_ATTRIBUTE");
  IElementType STYLE_REFERENCE = new ShapeElementType("STYLE_REFERENCE");
  IElementType STYLE_STATEMENT = new ShapeElementType("STYLE_STATEMENT");
  IElementType SWITCH_STATEMENT = new ShapeElementType("SWITCH_STATEMENT");
  IElementType TOP_LEVEL_STATEMENTS = new ShapeElementType("TOP_LEVEL_STATEMENTS");
  IElementType TRY_STATEMENT = new ShapeElementType("TRY_STATEMENT");
  IElementType TYPE = new ShapeElementType("TYPE");
  IElementType TYPE_CASTING_EXPR = new ShapeElementType("TYPE_CASTING_EXPR");
  IElementType TYPE_SPECIFIER = new ShapeElementType("TYPE_SPECIFIER");
  IElementType USE_BLOCK = new ShapeElementType("USE_BLOCK");
  IElementType USE_STATEMENT = new ShapeElementType("USE_STATEMENT");
  IElementType VARIABLE_DECLARATION = new ShapeElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_NAME = new ShapeElementType("VARIABLE_NAME");
  IElementType VIEW = new ShapeElementType("VIEW");
  IElementType VIEW_ATTRIBUTE_BLOCK = new ShapeElementType("VIEW_ATTRIBUTE_BLOCK");
  IElementType VIEW_BLOCK = new ShapeElementType("VIEW_BLOCK");
  IElementType VIEW_NAME = new ShapeElementType("VIEW_NAME");
  IElementType VIEW_RECOVER = new ShapeElementType("VIEW_RECOVER");
  IElementType WHILE_STATEMENT = new ShapeElementType("WHILE_STATEMENT");

  IElementType ASSIGN = new ShapeTokenType("=");
  IElementType AT = new ShapeTokenType("@");
  IElementType BIT_AND = new ShapeTokenType("&");
  IElementType BIT_AND_ASSIGN = new ShapeTokenType("&=");
  IElementType BIT_CLEAR = new ShapeTokenType("&^");
  IElementType BIT_CLEAR_ASSIGN = new ShapeTokenType("&^=");
  IElementType BIT_OR = new ShapeTokenType("|");
  IElementType BIT_OR_ASSIGN = new ShapeTokenType("|=");
  IElementType BIT_XOR = new ShapeTokenType("^");
  IElementType BIT_XOR_ASSIGN = new ShapeTokenType("^=");
  IElementType BOOLEAN = new ShapeTokenType("boolean");
  IElementType BREAK = new ShapeTokenType("break");
  IElementType BYTE = new ShapeTokenType("byte");
  IElementType CASE = new ShapeTokenType("case");
  IElementType CATCH = new ShapeTokenType("catch");
  IElementType CHAR = new ShapeTokenType("char");
  IElementType COLON = new ShapeTokenType(":");
  IElementType COMMA = new ShapeTokenType(",");
  IElementType COND_AND = new ShapeTokenType("&&");
  IElementType COND_OR = new ShapeTokenType("||");
  IElementType CONTINUE = new ShapeTokenType("continue");
  IElementType DECIMALI = new ShapeTokenType("decimali");
  IElementType DEFAULT = new ShapeTokenType("default");
  IElementType DO = new ShapeTokenType("do");
  IElementType DOT = new ShapeTokenType(".");
  IElementType DOUBLE = new ShapeTokenType("double");
  IElementType DP = new ShapeTokenType("dp");
  IElementType ELSE = new ShapeTokenType("else");
  IElementType EQ = new ShapeTokenType("==");
  IElementType FALSE = new ShapeTokenType("false");
  IElementType FINALLY = new ShapeTokenType("finally");
  IElementType FLOAT = new ShapeTokenType("float");
  IElementType FLOATI = new ShapeTokenType("floati");
  IElementType FOR = new ShapeTokenType("for");
  IElementType GT = new ShapeTokenType(">");
  IElementType GTE = new ShapeTokenType(">=");
  IElementType HEX = new ShapeTokenType("hex");
  IElementType IDENTIFIER = new ShapeTokenType("identifier");
  IElementType ID_SIGN = new ShapeTokenType("#");
  IElementType IF = new ShapeTokenType("if");
  IElementType IMPORT = new ShapeTokenType("import");
  IElementType INSTANCEOF = new ShapeTokenType("instanceof");
  IElementType INT = new ShapeTokenType("int");
  IElementType INTEGER = new ShapeTokenType("integer");
  IElementType LBRACE = new ShapeTokenType("{");
  IElementType LBRACK = new ShapeTokenType("[");
  IElementType LONG = new ShapeTokenType("long");
  IElementType LPAREN = new ShapeTokenType("(");
  IElementType LT = new ShapeTokenType("<");
  IElementType LTE = new ShapeTokenType("<=");
  IElementType MINUS = new ShapeTokenType("-");
  IElementType MINUS_ASSIGN = new ShapeTokenType("-=");
  IElementType MINUS_MINUS = new ShapeTokenType("--");
  IElementType MOD = new ShapeTokenType("%");
  IElementType MOD_ASSIGN = new ShapeTokenType("%=");
  IElementType MUL = new ShapeTokenType("*");
  IElementType MUL_ASSIGN = new ShapeTokenType("*=");
  IElementType NEW = new ShapeTokenType("new");
  IElementType NOT = new ShapeTokenType("!");
  IElementType NOTNULL = new ShapeTokenType("??");
  IElementType NOT_EQ = new ShapeTokenType("!=");
  IElementType NULL = new ShapeTokenType("null");
  IElementType OCT = new ShapeTokenType("oct");
  IElementType PLUS = new ShapeTokenType("+");
  IElementType PLUS_ASSIGN = new ShapeTokenType("+=");
  IElementType PLUS_PLUS = new ShapeTokenType("++");
  IElementType PX = new ShapeTokenType("px");
  IElementType QUESTION_MARK = new ShapeTokenType("?");
  IElementType QUOTIENT = new ShapeTokenType("/");
  IElementType QUOTIENT_ASSIGN = new ShapeTokenType("/=");
  IElementType RBRACE = new ShapeTokenType("}");
  IElementType RBRACK = new ShapeTokenType("]");
  IElementType RETURN = new ShapeTokenType("return");
  IElementType RPAREN = new ShapeTokenType(")");
  IElementType SEMICOLON = new ShapeTokenType(";");
  IElementType SEMICOLON_SYNTHETIC = new ShapeTokenType("<newline>");
  IElementType SHIFT_LEFT = new ShapeTokenType("<<");
  IElementType SHIFT_LEFT_ASSIGN = new ShapeTokenType("<<=");
  IElementType SHIFT_RIGHT = new ShapeTokenType(">>");
  IElementType SHIFT_RIGHT_ASSIGN = new ShapeTokenType(">>=");
  IElementType SHORT = new ShapeTokenType("short");
  IElementType SP = new ShapeTokenType("sp");
  IElementType STATIC = new ShapeTokenType("static");
  IElementType STR = new ShapeTokenType("str");
  IElementType STYLE = new ShapeTokenType("style");
  IElementType SUPER = new ShapeTokenType("super");
  IElementType SWITCH = new ShapeTokenType("switch");
  IElementType THIS = new ShapeTokenType("this");
  IElementType TRIPLE_DOT = new ShapeTokenType("...");
  IElementType TRUE = new ShapeTokenType("true");
  IElementType TRY = new ShapeTokenType("try");
  IElementType USE = new ShapeTokenType("use");
  IElementType WHILE = new ShapeTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ASSIGN_STATEMENT) {
        return new ShapeAssignStatementImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new ShapeAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_BLOCK) {
        return new ShapeAttributeBlockImpl(node);
      }
      else if (type == ATTRIBUTE_PAIR) {
        return new ShapeAttributePairImpl(node);
      }
      else if (type == ATTR_KEY) {
        return new ShapeAttrKeyImpl(node);
      }
      else if (type == ATTR_VALUE) {
        return new ShapeAttrValueImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new ShapeBreakStatementImpl(node);
      }
      else if (type == CLASS_NAME) {
        return new ShapeClassNameImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new ShapeContinueStatementImpl(node);
      }
      else if (type == DIMENSION) {
        return new ShapeDimensionImpl(node);
      }
      else if (type == DO_STATEMENT) {
        return new ShapeDoStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ShapeExpressionImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ShapeForStatementImpl(node);
      }
      else if (type == ID_DEFINITION) {
        return new ShapeIdDefinitionImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ShapeIfStatementImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ShapeImportStatementImpl(node);
      }
      else if (type == LOGICAL_EXPR) {
        return new ShapeLogicalExprImpl(node);
      }
      else if (type == NORMAL_EXPR) {
        return new ShapeNormalExprImpl(node);
      }
      else if (type == NUMERIC_EXPR) {
        return new ShapeNumericExprImpl(node);
      }
      else if (type == PACKAGE_NAME) {
        return new ShapePackageNameImpl(node);
      }
      else if (type == PARAMETER) {
        return new ShapeParameterImpl(node);
      }
      else if (type == POSTFIX_OPERATOR) {
        return new ShapePostfixOperatorImpl(node);
      }
      else if (type == PREFIX_OPERATOR) {
        return new ShapePrefixOperatorImpl(node);
      }
      else if (type == RESOURCE_REFERENCE) {
        return new ShapeResourceReferenceImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new ShapeReturnStatementImpl(node);
      }
      else if (type == ROOT_VIEW) {
        return new ShapeRootViewImpl(node);
      }
      else if (type == SELECTOR) {
        return new ShapeSelectorImpl(node);
      }
      else if (type == SINGLE_EXPR) {
        return new ShapeSingleExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new ShapeStatementImpl(node);
      }
      else if (type == STATEMENT_BLOCK) {
        return new ShapeStatementBlockImpl(node);
      }
      else if (type == STATE_ATTRIBUTE) {
        return new ShapeStateAttributeImpl(node);
      }
      else if (type == STYLE_REFERENCE) {
        return new ShapeStyleReferenceImpl(node);
      }
      else if (type == STYLE_STATEMENT) {
        return new ShapeStyleStatementImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new ShapeSwitchStatementImpl(node);
      }
      else if (type == TOP_LEVEL_STATEMENTS) {
        return new ShapeTopLevelStatementsImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new ShapeTryStatementImpl(node);
      }
      else if (type == TYPE) {
        return new ShapeTypeImpl(node);
      }
      else if (type == TYPE_CASTING_EXPR) {
        return new ShapeTypeCastingExprImpl(node);
      }
      else if (type == TYPE_SPECIFIER) {
        return new ShapeTypeSpecifierImpl(node);
      }
      else if (type == USE_BLOCK) {
        return new ShapeUseBlockImpl(node);
      }
      else if (type == USE_STATEMENT) {
        return new ShapeUseStatementImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new ShapeVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new ShapeVariableNameImpl(node);
      }
      else if (type == VIEW) {
        return new ShapeViewImpl(node);
      }
      else if (type == VIEW_ATTRIBUTE_BLOCK) {
        return new ShapeViewAttributeBlockImpl(node);
      }
      else if (type == VIEW_BLOCK) {
        return new ShapeViewBlockImpl(node);
      }
      else if (type == VIEW_NAME) {
        return new ShapeViewNameImpl(node);
      }
      else if (type == VIEW_RECOVER) {
        return new ShapeViewRecoverImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ShapeWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
