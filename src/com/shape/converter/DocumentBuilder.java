package com.shape.converter;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class DocumentBuilder {
    private StringBuilder document;
    private int indentation;
    private int spaceSize = 4;

    public DocumentBuilder() {
        document = new StringBuilder();
        indentation = 0;
    }

    public void indent() {
        indentation++;
    }

    public void unindent() {
        indentation--;
    }

    private String getSpaces() {
        StringBuilder space = new StringBuilder();
        for (int i=indentation*spaceSize; i>0; i--) space.append(" ");
        return space.toString();

    }

    public void append(String text) {
        document.append(getSpaces() + text);
    }

    public void appendBack(String text) {
        document.append(text);
    }

    public void removeBack() {
        document.deleteCharAt(document.length()-1);
    }
    public void append(String format, String ...args) {
        this.append(String.format(format, args));
    }

    @Override
    public String toString() {
        return document.toString();
    }
}
