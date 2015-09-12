package com.shape.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.psi.FileViewProvider;
import com.shape.idea.ShapeFileType;
import com.shape.idea.ShapeLanguage;
import org.jetbrains.annotations.NotNull;
 
import javax.swing.*;
 
public class ShapeFile extends PsiFileBase {
    public ShapeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ShapeLanguage.INSTANCE);
    }
 
    @NotNull
    @Override
    public com.intellij.openapi.fileTypes.FileType getFileType() {
        return ShapeFileType.INSTANCE;
    }
 
    @Override
    public String toString() {
        return "Shape File";
    }
 
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}