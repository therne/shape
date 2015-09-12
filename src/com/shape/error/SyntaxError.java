package com.shape.error;

import com.shape.lexer.Token;

public class SyntaxError extends LessError {
    int codeLineNo, codeColNo;

    public SyntaxError(String message, int lineNo, int colNo) {
        super(message);
        this.codeLineNo = lineNo;
        this.codeColNo = colNo;
    }

    public SyntaxError(String message, Token unexpected) {
        this(message, unexpected.getLineNo(), unexpected.getColNo());
    }

    public int getLineNo() {
        return codeLineNo;
    }

    public int getColumnNo() {
        return codeColNo;
    }
}
