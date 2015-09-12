package com.shape.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.shape.idea.ShapeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ShapeTokenType extends IElementType {
    public ShapeTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ShapeLanguage.INSTANCE);
    }
 
    @Override
    public String toString() {
        return "ShapeTokenType." + super.toString();
    }
}