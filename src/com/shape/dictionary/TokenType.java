package com.shape.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Token types - including operators, literals
 */
public enum TokenType {
    // Actually Ignored.
    UNKNOWN,
    NEWLINE,
    WHITE_SPACE,
    SEMICOLON_SYNTHETIC,

    NAME,

    // Keywords
    KEYWORD,
        BOOLEAN("boolean", KEYWORD),
        BREAK("break", KEYWORD),
        BYTE("byte", KEYWORD),
        CASE("case", KEYWORD),
        CHAR("char", KEYWORD),
        CONST("const", KEYWORD),
        CONTINUE("continue", KEYWORD),
        DO("do", KEYWORD),
        DOUBLE("double", KEYWORD),
        ELSE("else", KEYWORD),
        FINALLY("finally", KEYWORD),
        FLOAT("float", KEYWORD),
        FOR("for", KEYWORD),
        DEFAULT("default", KEYWORD),
        IMPORT("import", KEYWORD),
        USE("use", KEYWORD),
        INT("int", KEYWORD),
        LONG("long", KEYWORD),
        NEW("new", KEYWORD),
        IF("if", KEYWORD),
        SHORT("short", KEYWORD),
        SWITCH("switch", KEYWORD),
        RETURN("return", KEYWORD),
        VOID("void", KEYWORD),
        WHILE("while", KEYWORD),
        INCLUDE("include", KEYWORD),
        STYLE("style", KEYWORD),
        MIXIN("mixin", KEYWORD), // Reserved...

    // Units
    UNIT,
        PX ("px", UNIT),
        DP("dp", UNIT),
        PT ("pt", UNIT),
        SP ("sp", UNIT),

    // Comments (Actually ignored in AST)
    LINE_COMMENT,
    BLOCK_COMMENT,

    // Operators
    OPERATOR,
        COMMA (",", OPERATOR),
        DOT (".", OPERATOR),
        COLON (":", OPERATOR),
        ASSIGN("=", OPERATOR),
        ID_SIGN("#", OPERATOR),
        SEMICOLON (";", OPERATOR),
        BACKSLASH ("\\", OPERATOR),
        AT ("@", OPERATOR),
        QUESTION ("?", OPERATOR),

        // Operators - special
        SPECIAL (OPERATOR),
            INSTANCEOF ("instanceof", SPECIAL),
            NOTNULL ("??", SPECIAL),

        // Operators - Arithmetical
        ARITHMETIC (OPERATOR),
            PLUS ("+", ARITHMETIC),
            PLUS_PLUS ("++", ARITHMETIC),
            PLUS_ASSIGN ("+=", ARITHMETIC),
            MINUS ("-", ARITHMETIC),
            MINUS_MINUS ("--", ARITHMETIC),
            MINUS_ASSIGN ("-=", ARITHMETIC),
            MUL ("*", ARITHMETIC),
            MUL_ASSIGN ("*=", ARITHMETIC),
            QUOTIENT("/", ARITHMETIC),
            QUOTIENT_ASSIGN("/=", ARITHMETIC),
            MOD ("%", ARITHMETIC),
            MOD_ASSIGN ("%=", ARITHMETIC),

        // Operators - Bitwise
        BITWISE (OPERATOR),
            SHIFT_LEFT("<<", BITWISE),
            SHIFT_LEFT_ASSIGN("<<=", BITWISE),
            SHIFT_RIGHT(">>", BITWISE),
            SHIFT_RIGHT_ASSIGN(">>=", BITWISE),
            BIT_XOR("^", BITWISE),
            BIT_XOR_ASSIGN("^=", BITWISE),
            BIT_AND("&", BITWISE),
            BIT_AND_ASSIGN("&=", BITWISE),
            BIT_OR("|", BITWISE),
            BIT_OR_ASSIGN("|=", BITWISE),
            BIT_CLEAR("&^", BITWISE),
            BIT_CLEAR_ASSIGN("&^=", BITWISE),

        // Operators - Conditional
        CONDITIONAL(OPERATOR),
            NOT("!", CONDITIONAL),
            COND_AND("&&", CONDITIONAL),
            COND_OR("||", CONDITIONAL),

        // Operators - Relational
        RELATIONAL (OPERATOR),
            NOT_EQ("!=", RELATIONAL),
            EQ("==", RELATIONAL),
            GT (">", RELATIONAL),
            GTE (">=", RELATIONAL),
            LT ("<", RELATIONAL),
            LTE ("<=", RELATIONAL),

        // Operators - Brackets
        BRACKET (OPERATOR),
            LPAREN("(", BRACKET),
            RPAREN(")", BRACKET),
            LBRACK("[", BRACKET),
            RBRACK("]", BRACKET),
            LBRACE("{", BRACKET),
            RBRACE("}", BRACKET),

        // Operators - Reserved
        RESERVED (OPERATOR),
            QUESTION_MARK ("?"),
            CARET ("^"),
            ARROW_LEFT ("->"),
            ARROW_RIGHT ("<-"),

    // Literal tokens
    LITERAL,
        LITERAL_STRING (LITERAL),
        NUMBER(LITERAL),
            LITERAL_OCT(NUMBER),
            LITERAL_FLOAT(NUMBER),
            LITERAL_DECIMALI(NUMBER),
            LITERAL_HEX(NUMBER),
            LITERAL_INT(NUMBER),

        OLD_DOUBLE(LITERAL),

        LITERAL_TRUE ("true", LITERAL),
        LITERAL_FALSE ("false", LITERAL),
        LITERAL_NULL ("null", LITERAL),
        LITERAL_PERCENTAGE (LITERAL); // ex) 100%

    private static HashMap<String, TokenType> lexemeMap = new HashMap<>();

    private TokenType parent;
    private String lexeme;
    private List<TokenType> children = new ArrayList<>();

    static {
        // put all [lexeme: TokenType] pair to the lexemeMap,
        // so we can retrieve token types by lexeme
        for (TokenType type : TokenType.values()) {
            if (type.getLexeme() != null) lexemeMap.put(type.getLexeme(), type);
        }
    }

    private TokenType() {
        // usually special token or category token.
    }

    private TokenType(TokenType parent) {
        this.parent = parent;
    }

    private TokenType(String lexeme, TokenType parent) {
        this.parent = parent;
        this.lexeme = lexeme;

        parent.addToChild(this);
    }

    private TokenType(String lexeme) {
        this.lexeme = lexeme;
    }

    private void addToChild(TokenType child) {
        if (parent != null) parent.addToChild(child);
        children.add(child);
    }

    public List<TokenType> getChildren() {
        return children;
    }

    public static TokenType get(String lexeme) {
        return lexemeMap.get(lexeme);
    }

    public TokenType getParent() {
        return parent;
    }

    public String getLexeme() {
        return lexeme;
    }

    public boolean isInCategory(TokenType category) {
        for (TokenType child = this.parent; child != null; child = child.parent)
            if (category == child) return true;
        return false;
    }

    public boolean isOperator() {
        return isInCategory(OPERATOR);
    }

    public boolean isLitteral() {
        return isInCategory(LITERAL);
    }
}
