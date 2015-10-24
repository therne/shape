package com.shape.gradle

import com.shape.ast.Source
import com.shape.converter.XmlConverter
import com.shape.lexer.Lexer
import com.shape.lexer.TokenStream
import com.shape.parser.ModifyProcessor
import com.shape.parser.Parser
import groovy.io.FileType
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeConvertTask extends DefaultTask {

    // merged resources directory (usually build/incremental/res/$variant/)
    def File inputDir

    @TaskAction
    def run() {
        if (!inputDir.exists()) return

        inputDir.eachFileRecurse(FileType.FILES, { file ->
            // filter only .shp files
            if (!file.name.endsWith(".shp")) return

            // convert
            def doc = processSource(file)
            new File(file.path.substring(0, file.path.size() - 4) + ".xml").withWriter { it.append doc }
        })
    }

    static def processSource(File source) {
        // lexing!
        Lexer lexer = new Lexer(source)
        TokenStream tokens = lexer.perform()

        // Parsing
        Parser parser = new Parser()
        Source src = parser.parse(source.getName(), tokens)

        // Run Modifier
        ModifyProcessor.modify(src.getAst())

        // Convert to XML
        XmlConverter converter = new XmlConverter()
        String doc = converter.performConvert(src.getAst())

        return doc
    }
}
