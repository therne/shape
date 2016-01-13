package com.shape.idea.fakedom;

import com.android.tools.idea.AndroidPsiUtils;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlElement;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.xml.*;
import com.intellij.util.xml.reflect.AbstractDomChildrenDescription;
import com.intellij.util.xml.reflect.DomGenericInfo;
import com.shape.ast.attributes.Attribute;
import org.jetbrains.android.dom.AndroidDomElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class FakeDomElement implements AndroidDomElement {

    private Attribute attr;
    private FakeXmlAttribute fakeAttr;

    public FakeDomElement(Attribute attr, PsiElement e) {
        this.attr = attr;
        fakeAttr = new FakeXmlAttribute(attr, e);
    }

    @Override
    public XmlTag getXmlTag() {
        return null;
    }

    @Nullable
    @Override
    public XmlElement getXmlElement() {
        return fakeAttr;
    }

    @Override
    public DomElement getParent() {
        return null;
    }

    @Override
    public XmlTag ensureTagExists() {
        return null;
    }

    @Override
    public XmlElement ensureXmlElementExists() {
        return null;
    }

    @Override
    public void undefine() {

    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @NotNull
    @Override
    public DomGenericInfo getGenericInfo() {
        return null;
    }

    @NotNull
    @Override
    public String getXmlElementName() {
        return "(fake)";
    }

    @NotNull
    @Override
    public String getXmlElementNamespace() {
        return attr.getNamespace();
    }

    @Nullable
    @Override
    public String getXmlElementNamespaceKey() {
        return attr.getNamespace();
    }

    @Override
    public void accept(DomElementVisitor visitor) {

    }

    @Override
    public void acceptChildren(DomElementVisitor visitor) {

    }

    @NotNull
    @Override
    public DomManager getManager() {
        return DomManager.getDomManager(fakeAttr.getProject());
    }

    @NotNull
    @Override
    public Type getDomElementType() {
        return null;
    }

    @Override
    public AbstractDomChildrenDescription getChildDescription() {
        return null;
    }

    @NotNull
    @Override
    public DomNameStrategy getNameStrategy() {
        return null;
    }

    @NotNull
    @Override
    public ElementPresentation getPresentation() {
        return null;
    }

    @Override
    public GlobalSearchScope getResolveScope() {
        return null;
    }

    @Nullable
    @Override
    public <T extends DomElement> T getParentOfType(Class<T> requiredClass, boolean strict) {
        return null;
    }

    @Nullable
    @Override
    public Module getModule() {
        return AndroidPsiUtils.getModuleSafely(fakeAttr.elem);
    }

    @Override
    public void copyFrom(DomElement other) {

    }

    @Override
    public <T extends DomElement> T createMockCopy(boolean physical) {
        return null;
    }

    @Override
    public <T extends DomElement> T createStableCopy() {
        return null;
    }

    @Nullable
    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        // TODO: Need to write
        return null;
    }

    @Nullable
    @Override
    public <T> T getUserData(@NotNull Key<T> key) {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

    }
}
