package com.shape.ast.attributes

import com.shape.dictionary.AndroidDictionary

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
open class ResourceAttribute(
        key: String,
        value: String) : Attribute(key, value) {

    var resourceName: String? = null
    var resourceType: String? = null
    var resourcePackage: String? = null

    constructor(key: String,
                resourceType: String,
                resourceName: String) : this(key, "$resourceType/$resourceName") {

        this.resourceName = resourceName
        this.resourceType = resourceType

        // check package suffix(:) (ex: @android:color/black)
        val suffixIndex = resourceType.indexOf(':')
        if (suffixIndex != -1) {
            this.resourcePackage = resourceType.substring(0, suffixIndex)
            this.resourceType = resourceType.substring(suffixIndex + 1, resourceType.length)
        }

        // unknown resource type?
        for (type in AndroidDictionary.RESOURCE_TYPES) {
            if (type == resourceType) return
        }

        // TODO : throw SyntaxError if no token matches
        // throw SyntaxError("Unknown resource type : " + resourceType);
    }
}
