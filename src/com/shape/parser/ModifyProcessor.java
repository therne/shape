package com.shape.parser;

import com.shape.ast.attributes.Attribute;
import com.shape.ast.SyntaxTree;
import com.shape.ast.nodes.View;

import java.util.List;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ModifyProcessor {

    public static void modify(SyntaxTree tree) {
        runRecursive((View) tree.getRoot());
    }

    private static void runRecursive(View view) {
        List<Attribute> attributes = view.getAttributes();
        for (Attribute attr : attributes) {
            if (attr.hasModifier()) attr.getModifiers().forEach(m -> m.applyAction(view));
        }

        // child recursive
        view.getChildren().forEach(v -> runRecursive((View) v));
    }
}
