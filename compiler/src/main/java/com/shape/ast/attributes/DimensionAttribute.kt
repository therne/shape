package com.shape.ast.attributes

import com.shape.dictionary.TokenType
import com.shape.error.SyntaxError
import com.shape.lexer.Token

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class DimensionAttribute : ResourceAttribute {
    var valueI: Int = 0
    var valueD: Double = 0.0
    val type: Token?

    constructor(key: String, value: Token, typeToken: Token) : super(key, "") {
        type = typeToken

        if (value.type == TokenType.NUMBER) {
            this.valueI = Integer.parseInt(value.lexeme)
            this.value = valueI.toString() + typeToken.lexeme

        } else if (value.type == TokenType.OLD_DOUBLE) {
            this.valueD = java.lang.Double.parseDouble(value.lexeme)
            this.value = valueD.toString() + typeToken.lexeme
        }
    }
}