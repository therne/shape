package com.shape.ast.attributes

import com.shape.ast.nodes.View
import com.shape.dictionary.AndroidDictionary

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
open class Attribute @JvmOverloads constructor(key: String,
                     value: String,
                     namespace: String = "android") {
    var key = key
    var value = value
    var namespace = namespace
    val convertedKey = AndroidDictionary.originalAttrName(key)
    val convertedKeyWithNamespace = "$namespace:$convertedKey"
    val modifiers = arrayListOf<(View) -> Unit>()

    fun hasModifiers() = modifiers.size != 0


    override fun toString() = "$namespace:$convertedKey=\"$value\""
}