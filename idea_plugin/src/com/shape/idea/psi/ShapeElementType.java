package com.shape.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.shape.idea.ShapeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
 
public class ShapeElementType extends IElementType {
    public ShapeElementType(@NotNull @NonNls String debugName) {
        super(debugName, ShapeLanguage.INSTANCE);
    }
}