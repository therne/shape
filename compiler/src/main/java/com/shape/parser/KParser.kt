package com.shape.parser

import com.shape.ast.Modifiers
import com.shape.ast.attributes.*
import com.shape.ast.nodes.Node
import com.shape.ast.nodes.View
import com.shape.ast.styles.Style
import com.shape.dictionary.TokenType.*
import com.shape.error.SyntaxError
import com.shape.error.UnexpectedTokenError
import com.shape.lexer.Token
import java.util.*

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class KParser : BaseParser() {

    var parsingStyle: Style? = null

    override fun expect() {
        when (currToken.type) {
            IMPORT -> handleImport()
            INCLUDE -> handleInclude()
            NAME -> viewBegin()
            STYLE -> styleBegin()
            USE -> useBlock()

            else -> throw UnexpectedTokenError(currToken)
        }
    }

    override fun expectationMatched() {
        when (currentState) {
            ParsingState.VIEW -> {
                if (currToken.type == NAME) {
                    // if next is comma or close(')'), it is state attribute
                    val next = code.peekNext().type
                    if (next == COMMA || next == RPAREN) {
                        handleStateAttribute()
                        if (next == RPAREN) viewEnd()
                        pull()
                        return
                    }
                    else if (next != COLON) throw UnexpectedTokenError(currToken)

                    handleAttribute(false)
                    expectNext(NAME, COLON, COMMA, RPAREN)
                }
                else if (currToken.type == COMMA) expectNext(NAME, RPAREN)
                else if (currToken.type == RPAREN) viewEnd()
            }

            ParsingState.VIEW_END -> {
                if (currToken.type == LBRACE) {
                    // visit node
                    nodeStack.push(currentNode)
                    ast.visit(currentNode)

                } else if (currToken.type == RBRACE) {
                    // leave this node
                    nodeStack.pop()
                    ast.leave()

                } else if (currToken.type == NAME) {
                    // begin of another view
                    viewBegin()
                }
                else throw UnexpectedTokenError(currToken)
            }

            ParsingState.STYLE -> {
                if (currToken.type == NAME) {
                    handleAttribute(true)
                    expectNext(NAME, COLON, SEMICOLON, RBRACE)
                }
                else if (currToken.type == SEMICOLON) expectNext(NAME, COLON, RBRACE)
                else if (currToken.type == RBRACE) styleEnd()
            }
        }
    }

    fun viewBegin() {
        var id : String? = null
        var styleName: String?

        // Current token is class name.
        val view = View(currToken.lexeme)

        // before all, check first name is not whether id or style
        val firstLetter = currToken.lexeme.substring(0, 1)
        if (".#".contains(firstLetter)) {
            // unexpected # or .
            currToken.lexeme = firstLetter
            throw UnexpectedTokenError(currToken)
        }

        // find id and style
        while (expectAndPull(NAME, LPAREN).type != LPAREN) {
            val current = currToken.lexeme
            if (current.startsWith("#")) {
                if (id != null) throw SyntaxError("id must be unique", currToken)
                id = current.substring(1)
            }
            else if (current.startsWith(".")) {
                styleName = current.substring(1)

                // search for style
                val style = source.getStyle(styleName)
                if (style != null) view.applyStyle(style)
                else {
                    // TODO: 뷰 뒤에 스타일이 선언되어있을 경우를 고려 - 무조건 리소스 취급하고 예외처리하면 안됨.
                    // not shape style. it would be Android style resources
                    if (view.styleResourceName != null)
                        throw SyntaxError("you must assign one style resource at one view.", currToken)

                    view.styleResourceName = styleName
                }
            }
        }

        if (id != null) view.id = id

        // Add view to the AST
        view.parent = if (nodeStack.size == 0) null else nodeStack.lastElement()
        currentNode = view

        setState(ParsingState.VIEW)
        expectNext(NAME, RPAREN)
    }

    fun viewEnd() {
        // add this view to AST
        ast.addNode(currentNode)

        setState(ParsingState.VIEW_END)
        expectNext(NAME, LBRACE, RBRACE)
    }

    fun handleImport() {
        // import must be top of the layer. not in the View block.
        if (!nodeStack.isEmpty()) throw SyntaxError("import must be top", currToken)

        // get import target (module name)
        val targetName = expectAndPull(LITERAL_STRING)

        // TODO: IMPORT!
    }

    fun handleInclude() {
        // include must be in the view or layout block.
        if (nodeStack.isEmpty()) throw SyntaxError("'include' must be in the View or Layout.", currToken)

        // TODO: INCLUDE!
    }

    fun useBlock() {
        val next = expectAndPull(NAME, LBRACE)
        if (next.type == NAME) {

        }
    }

    fun styleBegin() {
        // TODO: 범위한정

        // get name
        val name = expectAndPull(NAME).lexeme
        parsingStyle = Style(name)

        // round bracket: selector, brace: just style
        val next = expectAndPull(LPAREN, LBRACE)
        if (next.type == LPAREN) {
            setState(ParsingState.STYLE_SELECTOR)
            expectNext(NAME, RPAREN)

        } else {
            setState(ParsingState.STYLE)
            expectNext(NAME, RBRACE)
        }
    }

    fun styleEnd() {
        source.addStyle(parsingStyle)
        expectNext()
    }

    fun handleAttribute(isStyle: Boolean) {
        val attrKey = currToken.lexeme

        // move cursor to the value part
        pull()
        pull()

        // Add attribute to style or view node.
        val addTo = (if (isStyle) parsingStyle else currentNode) ?: return

        // Resource Reference (@[package:]type/resourceName)
        if (currToken.type == NAME && (currToken.lexeme.startsWith("@") || currToken.lexeme.startsWith("?"))) {
            handleResourceRef(addTo, attrKey)
        }

        // or dimension
        else if (currToken.type == NUMBER || currToken.type == OLD_DOUBLE) {
            handleDimension(addTo, attrKey)

        } else handleOtherAttribute(addTo, attrKey)
    }

    fun handleResourceRef(node: Node, attrKey: String) {
        val resType = currToken.lexeme // ex) @string, ?attr, ...
        expectAndPull(QUOTIENT)  // /
        expectAndPull(NAME) // value

        node.addAttribute(ResourceAttribute(attrKey, resType, currToken.lexeme))
    }

    fun handleDimension(node: Node, attrKey: String) {
        val value = currToken

        // TODO: 하드코딩 나빠효.
        if (attrKey == "padding" || attrKey == "margin") {
            parseDirectionalAttribute(node, attrKey, value)
            return
        }

        expectAndPull(MOD, UNIT)

        // unit - dp, px, sp...
        if (currToken.type.isInCategory(UNIT)) {
            node.addAttribute(DimensionAttribute(attrKey, value, currToken))
        }

        // percent (%) : weight
        else if (currToken.getType() == MOD) {
            node.addAttribute(LayoutParam(attrKey, "wrap"))

            val percentage = value.lexeme.toDouble()
            if (percentage == 0.0 || percentage > 100)
                throw SyntaxError("percentage out of bound : $percentage%.", currToken.lineNo, currToken.colNo)

            val weightAttr = Attribute("weight", value.lexeme)
            weightAttr.modifiers.add(Modifiers.weightModifer)
            weightAttr.modifiers.add(Modifiers.weightSumModifier)
            node.addAttribute(weightAttr)
        }
    }

    private val DIRECTION_ORDER = arrayOf("Top", "Left", "Bottom", "Right")
    private val ALLOWED = Arrays.asList(RBRACE, COMMA, OLD_DOUBLE, NUMBER)

    fun parseDirectionalAttribute(node: Node, key: String, firstValue: Token) {
        // first, add top
        val values = ArrayList<Token>(4)
        val units = ArrayList<Token?>(4)

        values.add(firstValue)
        if (code.peekNext().isInCategory(UNIT)) units.add(code.next())
        else if (ALLOWED.contains(code.peekNext().type)) units.add(null)
        else throw UnexpectedTokenError(code.peekNext())

        while (code.peekNext().type != RPAREN && code.peekNext().type != COMMA && code.peekNext().type != RBRACE
                && !(code.peekNext().type == NAME && !code.peekNext().isInCategory(UNIT))) {
            values.add(expectAndPull(NUMBER, OLD_DOUBLE)) // value

            if (code.peekNext().isInCategory(UNIT)) units.add(code.next())
            else if (ALLOWED.contains(code.peekNext().type)) units.add(null)
            else throw UnexpectedTokenError(code.peekNext())
        }

        // just one value margin or padding (applied to all directions by default)
        if (values.size == 1) {
            if (units[0] == null)
                throw SyntaxError("you must give unit! (dp, sp, px...)", firstValue.lineNo, firstValue.colNo)

            node.addAttribute(DimensionAttribute(key, firstValue, units[0] ?: return))
        }

        // check any unit exists
        var hasUnit = false
        for (unit in units) {
            if (unit != null) hasUnit = true
        }
        if (!hasUnit)
            throw SyntaxError("you must give at least one unit! (dp, sp, px...)", firstValue.lineNo, firstValue.colNo)

        val len = values.size
        val globalUnit = units[units.size - 1] ?:
                throw SyntaxError("you must give unit at last dimension. (dp, sp, px..)",
                    values[len - 1].lineNo, values[len - 1].colNo) // TODO: lastValue

        for (i in 0..len - 1) {
            node.addAttribute(DimensionAttribute(key + DIRECTION_ORDER[i], values[i], units[i] ?: globalUnit))
        }
    }

    fun handleOtherAttribute(node: Node, attrKey: String) {
        val value = currToken.lexeme
        val attr: Attribute

        // determine attribute type
        if (attrKey == "font") {
            attr = FontAttribute(value)

        } else if (attrKey == "width" || attrKey == "height") {
            attr = LayoutParam(attrKey, value)

        } else if (attrKey == "weight") {
            // Apply Modifier for optimization (layout_height=0dp)
            attr = Attribute(attrKey, value)
            attr.modifiers.add(Modifiers.weightModifer)

        } else {
            attr = Attribute(attrKey, value)
        }
        node.addAttribute(attr)
    }

    fun handleStateAttribute() {
        val attr = when(currToken.lexeme) {
            "vertical" -> Attribute("orientation", "vertical")
            "horizontal" -> Attribute("orientation", "horizontal")
            "editable" -> Attribute("editable", "true")
            "visible" -> Attribute("visibility", "visible")
            "invisible" -> Attribute("visibility", "invisible")
            "focusable" -> Attribute("focusable", "true")
            "clickable" -> Attribute("clickable", "true")
            else -> throw SyntaxError("no state attribute found : " + currToken.lexeme, currToken)
        }
        currentNode.addAttribute(attr)
    }

}