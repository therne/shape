package com.shape.error;

public class LessError extends Exception {
    public LessError(String message) {
        super(message);
    }

    public LessError(String format, String ...args) {
        super(String.format(format, args));
    }
}
