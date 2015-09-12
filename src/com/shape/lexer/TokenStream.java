package com.shape.lexer;

import java.util.ArrayList;

public class TokenStream extends ArrayList<Token> {
    int index = 0;

    public void append(Token token) {
        this.add(token);
    }

    public Token current() {
        // TODO: probable range problem?
        return this.get(index);
    }

    public Token next() {
        return index == this.size() ? null : this.get(index++);
    }

    public Token peekNext() {
        return this.get(index);
    }

    public Token peekNext(int indexAmount) {
        return this.get(index + indexAmount);
    }

    public Token peekPrev() {
        return index == 0 ? null : this.get(index-1);
    }
}
