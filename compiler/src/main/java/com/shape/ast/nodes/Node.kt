package com.shape.ast.nodes

import com.shape.ast.attributes.Attribute

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
open class Node {
    // parent, child nodes
    var parent: Node? = null
    val children = arrayListOf<Node>()

    // attributes
    val attributes = arrayListOf<Attribute>()
    val attributeMap = hashMapOf<String, Attribute>()

    fun addChild(child: Node) {
        children += child
    }

    fun addAttribute(attr: Attribute) {
        val old = attributeMap[attr.key]
        if (old != null) {
            old.value = attr.value
            return
        }
        attributes += attr
        attributeMap[attr.key] = attr
    }
}