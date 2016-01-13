package com.shape.ast.nodes

import com.shape.ast.attributes.Attribute
import com.shape.ast.attributes.StyleAttribute
import com.shape.ast.styles.Style

/**
 * View Node - including other Views, ViewGroup (Layouts)
 */
class View : Node {
    var className: String?
    var styleResourceName: String? = null
        set(name) {
            field = name
            addAttribute(StyleAttribute(name as String))
        }

    var id: String? = null
        set(value) {
            field = value
            addAttribute(Attribute("id", "@+id/$id"))
        }

    private val stylesApplied = arrayListOf<Style>()

    constructor(className: String) : super() {
        this.className = className

        // default layout attributes
        addAttribute(Attribute("width", "wrap_content"))
        addAttribute(Attribute("height", "wrap_content"))
    }

    fun applyStyle(style: Style) {
        stylesApplied += style
        style.attributes.forEach { addAttribute(it) }
    }
}