package com.shape.lexer;

import com.shape.dictionary.TokenType;

/**
 * The basic unit of the code.
 */
public class Token {
    private String lexeme;
    private TokenType type;

    // for detailed error information..
    private int lineNo, colNo;

    public Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public Token(TokenType type) {
        this.type = type;
    }

    public void setCodeOffsetInformation(int lineNo, int colNo) {
        this.lineNo = lineNo;
        this.colNo = colNo;
    }

    public int getLineNo() {
        return lineNo;
    }

    public int getColNo() {
        return colNo;
    }

    /**
     * @return A Lexeme (actual content of the token)
     */
    public String getLexeme() {
        return (lexeme == null ? type.getLexeme() : lexeme);
    }

    @Override
    public String toString() {
        return getLexeme();
    }

    /**
     * Changes the lexeme. (NOTE: MODIFYING LEXEME IS LIMITED TO VERY SPECIAL CASE)
     * @param newLexeme new content of the token
     */
    public void setLexeme(String newLexeme) {
        this.lexeme = newLexeme;
    }

    /**
     * @return Type of a token {@link TokenType}
     */
    public TokenType getType() {
        return type;
    }

    public boolean isInCategory(TokenType category) {
        return this.type.isInCategory(category);
    }
}
