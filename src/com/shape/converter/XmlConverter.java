package com.shape.converter;

import com.shape.ast.attributes.Attribute;
import com.shape.dictionary.AndroidDictionary;
import com.shape.ast.SyntaxTree;
import com.shape.ast.nodes.Node;
import com.shape.ast.nodes.View;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class XmlConverter {

    /**
     * Convert given AST node to XML String. (Recursive)
     * @param node Node {@link Node}
     * @return XML
     */
    private String convertNode(Node node, DocumentBuilder doc) {
        View view = (View) node;

        // starting tag
        String className = AndroidDictionary.widgetName(view.getClassName());
        doc.append("<%s ", className);
        if (node.getParent() == null) doc.appendBack("xmlns:android=\"http://schemas.android.com/apk/res/android\"\n");
        else doc.appendBack("\n");

        // attributes
        doc.indent();
        for (Attribute attr : view.getAttributes()) {
            doc.append(attr.toString() + "\n");
        }

        // children
        if (view.getChildren().size() > 0) {
            doc.removeBack();
            doc.appendBack(">\n\n");

            for (Node child : node.getChildren()) convertNode(child, doc);
            doc.unindent();

            // closing tag
            doc.append("</%s>\n\n", className);

        } else {
            // self-closing
            doc.removeBack();
            doc.appendBack(" />\n\n");
            doc.unindent();
        }
        return doc.toString();
    }

    public String performConvert(SyntaxTree ast) {
        DocumentBuilder doc = new DocumentBuilder();
        return convertNode(ast.getRoot(), doc);
    }
}
