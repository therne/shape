package com.shape.ast;

import com.shape.ast.styles.Style;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstraction of the .shp Source File.
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class Source {
    private static final Map<String, Source> SOURCE_MAP = new HashMap<>();

    public static Source getByName(String name) {
        return SOURCE_MAP.get(name);
    }

    private String name;
    private SyntaxTree ast;
    private HashMap<String, Style> styles = new HashMap<>();
    // TODO: Mixin

    public Source(String name) {
        this.name = name;
        ast = new SyntaxTree();
        SOURCE_MAP.put(name, this);
    }

    public void setAst(SyntaxTree ast) {
        this.ast = ast;
    }

    public SyntaxTree getAst() {
        return ast;
    }

    public void addStyle(Style style) {
        styles.put(style.getName(), style);
    }

    public Style getStyle(String name) {
        return styles.get(name);
    }

    public boolean isStyleExists(String name) {
        return styles.containsKey(name);
    }
}
