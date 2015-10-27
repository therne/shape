package com.shape

import com.shape.ast.Source
import com.shape.ast.SyntaxTree
import com.shape.converter.ShapeConverter
import com.shape.converter.XmlConverter
import com.shape.lexer.Lexer
import com.shape.parser.ModifyProcessor
import com.shape.parser.Parser
import com.shape.parser.XmlParser
import org.w3c.dom.Document
import java.io.*
import kotlin.dom.*

/**
 * ShapeCompiler
 * Trans-compiles Shape source into XML, and vice versa.
 *
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeCompiler {
    val fileName: String
    val stream: InputStream
    val parser = Parser()

    constructor(file: File) {
        this.fileName = file.name
        this.stream = FileInputStream(file)
    }

    constructor(fileName: String, document: String) {
        this.fileName = fileName
        this.stream = document.byteInputStream()
    }

    /**
     * Parses Shape code and generates {@link Source} and AST.
     * @return Source with AST {@link SyntaxTree}
     */
    fun parse() : Source = parser.parse(fileName, Lexer(stream).perform())

    /**
     * Trans-compiles Shape code(.shp) into XML codes.
     * @return Shape document {String}
     */
    fun compileToXml() : String {
        val src = parse()
        ModifyProcessor.modify(src.ast)
        return XmlConverter().performConvert(src.ast)
    }

    /**
     * Trans-compiles XML code into Shape codes.
     * @return XML document {String}
     */
    fun compileToShape() : String {
        val src = XmlParser(stream).parse()
        return ShapeConverter().performConvert(src)
    }
}