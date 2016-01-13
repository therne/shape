package com.shape.ast.styles

import com.shape.ast.nodes.Node

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class Style(name: String) : Node() {
    val name = name
    var selector: Selector? = null
}