package com.shape.idea.completion;

import com.intellij.lang.SmartEnterProcessorWithFixers;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.shape.idea.psi.ShapeViewBlock;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeSmartEnterProcessor extends SmartEnterProcessorWithFixers {
    public ShapeSmartEnterProcessor() {
        addEnterProcessors(new BlockEnterProcessor());
    }

    private static class BlockEnterProcessor extends FixEnterProcessor {

        @Override
        public boolean doEnter(PsiElement atCaret, PsiFile file, Editor editor, boolean modified) {
            System.out.println(atCaret.getClass().getName());
            if (atCaret.getParent() instanceof ShapeViewBlock) {
                plainEnter(editor);
            }
            return false;
        }
    }
}
