package com.shape

import com.shape.ast.Source
import com.shape.converter.XmlConverter
import com.shape.lexer.Lexer
import com.shape.parser.ModifyProcessor
import com.shape.parser.Parser
import java.io.File
import java.io.FileReader
import java.io.Reader
import java.io.StringReader

/**
 * ShapeCompiler
 * Trans-compiles Shape source into XML, and vice versa.
 *
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeCompiler {
    val fileName: String
    val docReader: Reader
    val parser = Parser()

    constructor(file: File) {
        this.fileName = file.name
        this.docReader = FileReader(file)
    }

    constructor(fileName: String, document: String) {
        this.fileName = fileName
        this.docReader = StringReader(document)
    }

    /**
     * Parses Shape code and generates {@link Source} and AST.
     * @return Source with AST {@link SyntaxTree}
     */
    fun parse() : Source = parser.parse(fileName, Lexer(docReader).perform())

    /**
     * Trans-compiles Shape code(.shp) into XML codes.
     * @return Shape document {String}
     */
    fun compileToXml() : String {
        val src: Source = parse()
        ModifyProcessor.modify(src.ast)
        return XmlConverter().performConvert(src.ast)
    }
}