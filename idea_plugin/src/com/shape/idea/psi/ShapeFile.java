package com.shape.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.impl.source.xml.XmlFileImpl;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.xml.XmlTag;
import com.shape.idea.ShapeFileType;
import com.shape.idea.ShapeLanguage;
import org.jetbrains.annotations.NotNull;
 
import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public class ShapeFile extends XmlFileImpl {

    @NotNull private final Language myLanguage;
    @NotNull private final ParserDefinition myParserDefinition;

    public ShapeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LanguageParserDefinitions.INSTANCE.forLanguage(ShapeLanguage.INSTANCE).getFileNodeType());

        myLanguage = findLanguage(ShapeLanguage.INSTANCE, viewProvider);
        myParserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(myLanguage);
    }

    @Override
    public XmlTag getRootTag() {
        return super.getRootTag();
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

    @NotNull
    public ParserDefinition getParserDefinition() {
        return myParserDefinition;
    }

    private static Language findLanguage(Language baseLanguage, FileViewProvider viewProvider) {
        final Set<Language> languages = viewProvider.getLanguages();
        for (final Language actualLanguage : languages) {
            if (actualLanguage.isKindOf(baseLanguage)) {
                return actualLanguage;
            }
        }
        throw new AssertionError(
                "Language " + baseLanguage + " doesn't participate in view provider " + viewProvider + ": " + new ArrayList<Language>(languages));
    }
}