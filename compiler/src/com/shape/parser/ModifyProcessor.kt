package com.shape.parser

import com.shape.ast.SyntaxTree
import com.shape.ast.nodes.View

object ModifyProcessor {
    fun modify(tree: SyntaxTree) {
        runRecursive(tree.root as View)
    }

    private fun runRecursive(view: View) {
        view.attributes
                .filter { it.hasModifiers() }
                .forEach { attr -> attr.modifiers.forEach { it(view) } }
        view.children.forEach { runRecursive(it as View) }
    }
}
