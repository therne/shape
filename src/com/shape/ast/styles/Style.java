package com.shape.ast.styles;

import com.shape.ast.nodes.Node;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class Style extends Node {
    private String name;
    private Selector selector;

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
