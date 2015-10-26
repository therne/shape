package com.shape.ast

import com.shape.ast.nodes.Node

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class SyntaxTree {
    var current: Node? = null
        private set

    var root: Node? = null
        private set

    fun addNode(node: Node) {
        if (root == null) {
            root = node
            current = node
        }
        else current?.addChild(node)
    }

    fun visit(node: Node) {
        if (node.parent != null && node.parent !== current)
            throw IllegalArgumentException("you can only visit children of current node")
        current = node
    }

    fun visitNodes(callback: (Node?) -> Unit) {
        callback(root as Node)
        visitNodes(root as Node, callback)
    }

    fun leave() {
        current = current?.parent
    }

    private fun visitNodes(node: Node, callback: (Node?) -> Unit) {
        for (child in node.children) {
            callback(child)
            visitNodes(child, callback)
        }
    }
}