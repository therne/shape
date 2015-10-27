package com.shape.parser

import com.shape.ast.SyntaxTree
import com.shape.ast.attributes.Attribute
import com.shape.ast.nodes.View
import com.shape.dictionary.AndroidDictionary
import org.w3c.dom.Document
import org.w3c.dom.Node as DomNode
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import kotlin.dom.parseXml
import kotlin.dom.toElementList

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class XmlParser(stream: InputStream) {
    val tree = SyntaxTree()
    val stream = stream

    constructor(file: File) : this(FileInputStream(file))

    fun parse() : SyntaxTree {
        doParsing(parseXml(stream).firstChild) // root tag
        return tree
    }

    private fun doParsing(node: DomNode) {
        val view = View(AndroidDictionary.shapeClassName(node.nodeName))

        if (node.hasAttributes()) {
            val count = node.attributes.length
            var i = 0
            while (i < count) {
                val domAttr = node.attributes.item(i++)
                var attrName = domAttr.nodeName
                val attrValue = domAttr.nodeValue

                if (attrName.startsWith("xmlns:")) continue
                else if (attrName.startsWith("android:")) {
                    view.addAttribute(Attribute(
                            AndroidDictionary.shapeAttrName(attrName.replace("android:", "")),
                            AndroidDictionary.shapeParam(attrValue),
                            "android"));
                }
                else view.addAttribute(Attribute(AndroidDictionary.shapeAttrName(attrName),
                        AndroidDictionary.shapeParam(attrValue)))
            }
        }
        tree.addNode(view)
        tree.visit(view)

        // child recursion
        if (node.hasChildNodes()) {
            val count = node.childNodes.length
            var i = 0
            while (i < count) {
                doParsing(node.childNodes.item(i++))
            }
        }
        tree.leave()
    }
}