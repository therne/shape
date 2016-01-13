package com.shape.error;

public class ShapeError extends Exception {
    public ShapeError(String message) {
        super(message);
    }

    public ShapeError(String format, String... args) {
        super(String.format(format, args));
    }
}
