package com.shape.ast.attributes

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class StyleAttribute(value: String) : Attribute("style", value) {
    override fun toString() = "style=\"@style/$value\""
}