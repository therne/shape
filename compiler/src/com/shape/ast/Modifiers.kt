package com.shape.ast

import com.shape.Log
import com.shape.ast.attributes.Attribute
import com.shape.ast.nodes.View

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
object Modifiers {
    /**
     * Sets width or height to 0dp when layout_weight is given.
     */
    @JvmField final val weightModifer = modifier@ { view: View ->
        // parent LinearLayout
        val parent = view.parent as View
        val targetName: String

        if (parent == null) return@modifier

        val orient = parent.attributeMap["orientation"]
        if (orient != null && orient.value == "vertical")
            targetName = "layout_height"
        else
            targetName = "layout_width"

        // modify to 0dp
        view.attributeMap[targetName]?.value = "0dp"
    }

    /**
     * Sets parent weightSum to 100. (used in percents)
     */
    @JvmField final val weightSumModifier = modifier@ { view: View ->
        val parent = view.parent as View
        parent?.addAttribute(Attribute("weightSum", "100"))
    }
}