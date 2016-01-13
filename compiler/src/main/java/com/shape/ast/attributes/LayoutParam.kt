package com.shape.ast.attributes

import com.shape.dictionary.AndroidDictionary

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class LayoutParam(key: String, param: String) :
        Attribute(key, AndroidDictionary.originalParam(param))