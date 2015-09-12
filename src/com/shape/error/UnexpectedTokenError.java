package com.shape.error;

import com.shape.dictionary.TokenType;
import com.shape.lexer.Token;

import java.util.List;

public class UnexpectedTokenError extends SyntaxError {

    private List<TokenType> expected;
    private Token found;

    public UnexpectedTokenError(String message, int lineNo, int colNo) {
        super(message, lineNo, colNo);
    }

    public UnexpectedTokenError(Token found) {
        super("unexpected token '" + found.getLexeme() + "'", found.getLineNo(), found.getColNo());
    }

    public UnexpectedTokenError(List<TokenType> expected, Token found) {
        this(found);
        this.found = found;
        this.expected = expected;
    }

    @Override
    public String getMessage() {
        if (this.expected != null) {
            StringBuilder message = new StringBuilder();
            message.append("unexpected token '");
            message.append(found.getLexeme());
            message.append("' - ");

            for (int i=0; i<expected.size(); i++) {
                message.append('\'')
                        .append(tokenTypeToString(expected.get(i)))
                        .append(i == expected.size() - 1 ? "\'" : "' or ");
            }
            message.append(" expected");
            return message.toString();
        } else return super.getMessage();
    }

    private String tokenTypeToString(TokenType token) {
        String lexeme = token.getLexeme();
        return lexeme != null ? lexeme : token.getClass().getSimpleName();
    }
}
