package com.shape.converter

import com.shape.ast.SyntaxTree
import com.shape.ast.nodes.Node
import com.shape.ast.nodes.View

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeConverter {
    /**
     * Convert given AST node to Shape document. (Recursive)
     * @param node Node [Node]
     * *
     * @return Shape doc
     */
    private fun convertNode(node: Node, doc: DocumentBuilder): String {
        val view = node as View
        doc.append("%s (", view.className)

        // attributes
        for (attr in view.attributes) {
            doc.appendBack("${attr.key}: ${attr.value}, ")
        }
        doc.removeBack()
        doc.removeBack()
        doc.appendBack(")")

        // children
        if (view.children.size > 0) {
            doc.appendBack(" {\n")

            doc.indent()
            for (child in node.children) convertNode(child, doc)
            doc.unindent()

            // closing tag
            doc.append("}\n\n")

        } else doc.appendBack("\n")
        return doc.toString()
    }

    fun performConvert(ast: SyntaxTree): String {
        val doc = DocumentBuilder()
        return convertNode(ast.root as Node, doc)
    }
}