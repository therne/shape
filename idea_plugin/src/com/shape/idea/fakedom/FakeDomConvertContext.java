package com.shape.idea.fakedom;

import com.android.tools.idea.AndroidPsiUtils;
import com.intellij.openapi.module.Module;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlElement;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.xml.ConvertContext;
import com.intellij.util.xml.DomElement;
import com.shape.ast.attributes.Attribute;
import com.shape.idea.psi.ShapeAttrUtils;
import com.shape.idea.psi.ShapeAttributePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class FakeDomConvertContext extends ConvertContext {

    private PsiElement e;
    private XmlAttribute xmlElement;
    private DomElement domElement;

    public FakeDomConvertContext(ShapeAttributePair e) {
        this.e = e;

        Attribute attr = ShapeAttrUtils.getAttribute(e);
        xmlElement = new FakeXmlAttribute(attr, e);
        domElement = new FakeDomElement(attr, e);
    }

    @NotNull
    @Override
    public DomElement getInvocationElement() {
        return domElement;
    }

    @Nullable
    @Override
    public XmlTag getTag() {
        return null;
    }

    @Nullable
    @Override
    public XmlElement getXmlElement() {
        return xmlElement;
    }

    @NotNull
    @Override
    public XmlFile getFile() {
        return (XmlFile) e.getContainingFile();
    }

    @Nullable
    @Override
    public Module getModule() {
        return AndroidPsiUtils.getModuleSafely(e);
    }

    @Nullable
    @Override
    public GlobalSearchScope getSearchScope() {
        return e.getResolveScope();
    }

    @Override
    public PsiManager getPsiManager() {
        return e.getManager();
    }
}
