package com.shape.idea.fakedom;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiElementProcessor;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlElement;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.IncorrectOperationException;
import com.intellij.xml.XmlAttributeDescriptor;
import com.shape.ast.attributes.Attribute;
import com.shape.idea.ShapeLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Fake XML Attribute to CHEAT Android DOM Utilities. :P
 *
 * @author Vista
 */
public class FakeXmlAttribute implements XmlAttribute {

    Attribute shapeAttr;
    PsiElement elem;

    public FakeXmlAttribute(Attribute attr, PsiElement element) {
        shapeAttr = attr;
        elem = element;
    }

    @NotNull
    @Override
    public String getName() {
        return shapeAttr.getKey();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return null;
    }

    @NotNull
    @Override
    public String getLocalName() {
        return shapeAttr.getKey();
    }

    @Override
    public XmlElement getNameElement() {
        return null;
    }

    @NotNull
    @Override
    public String getNamespace() {
        return shapeAttr.getNamespace();
    }

    @NotNull
    @Override
    public String getNamespacePrefix() {
        return shapeAttr.getNamespace();
    }

    @NotNull
    @Override
    public Project getProject() throws PsiInvalidElementAccessException {
        return elem.getProject();
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return ShapeLanguage.INSTANCE;
    }

    @Override
    public PsiManager getManager() {
        return elem.getManager();
    }

    @NotNull
    @Override
    public PsiElement[] getChildren() {
        return elem.getChildren();
    }

    @Override
    public XmlTag getParent() {
        return null;
    }

    @Override
    public PsiElement getFirstChild() {
        return elem.getFirstChild();
    }

    @Override
    public PsiElement getLastChild() {
        return elem.getLastChild();
    }

    @Override
    public PsiElement getNextSibling() {
        return elem.getNextSibling();
    }

    @Override
    public PsiElement getPrevSibling() {
        return elem.getPrevSibling();
    }

    @Override
    public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
        return elem.getContainingFile();
    }

    @Override
    public TextRange getTextRange() {
        return elem.getTextRange();
    }

    @Override
    public int getStartOffsetInParent() {
        return elem.getStartOffsetInParent();
    }

    @Override
    public int getTextLength() {
        return elem.getTextLength();
    }

    @Nullable
    @Override
    public PsiElement findElementAt(int offset) {
        return elem.findElementAt(offset);
    }

    @Nullable
    @Override
    public PsiReference findReferenceAt(int offset) {
        return elem.findReferenceAt(offset);
    }

    @Override
    public int getTextOffset() {
        return elem.getTextOffset();
    }

    @Override
    public String getText() {
        return elem.getText();
    }

    @NotNull
    @Override
    public char[] textToCharArray() {
        return elem.textToCharArray();
    }

    @Override
    public PsiElement getNavigationElement() {
        return elem.getNavigationElement();
    }

    @Override
    public PsiElement getOriginalElement() {
        return elem.getOriginalElement();
    }

    @Override
    public boolean textMatches(@NotNull CharSequence text) {
        return elem.textMatches(text);
    }

    @Override
    public boolean textMatches(@NotNull PsiElement element) {
        return elem.textMatches(element);
    }

    @Override
    public boolean textContains(char c) {
        return elem.textContains(c);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        elem.accept(visitor);
    }

    @Override
    public void acceptChildren(@NotNull PsiElementVisitor visitor) {
        elem.acceptChildren(visitor);
    }

    @Override
    public PsiElement copy() {
        return elem.copy();
    }

    @Override
    public PsiElement add(@NotNull PsiElement element) throws IncorrectOperationException {
        return elem.add(element);
    }

    @Override
    public PsiElement addBefore(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
        return elem.addBefore(element, anchor);
    }

    @Override
    public PsiElement addAfter(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
        return elem.addAfter(element, anchor);
    }

    @Override
    public void checkAdd(@NotNull PsiElement element) throws IncorrectOperationException {
    }

    @Override
    public PsiElement addRange(PsiElement first, PsiElement last) throws IncorrectOperationException {
        return elem.addRange(first, last);
    }

    @Override
    public PsiElement addRangeBefore(@NotNull PsiElement first, @NotNull PsiElement last, PsiElement anchor) throws IncorrectOperationException {
        return elem.addRangeBefore(first, last, anchor);
    }

    @Override
    public PsiElement addRangeAfter(PsiElement first, PsiElement last, PsiElement anchor) throws IncorrectOperationException {
        return elem.addRangeAfter(first, last, anchor);
    }

    @Override
    public void delete() throws IncorrectOperationException {
    }

    @Override
    public void checkDelete() throws IncorrectOperationException {

    }

    @Override
    public void deleteChildRange(PsiElement first, PsiElement last) throws IncorrectOperationException {

    }

    @Override
    public PsiElement replace(@NotNull PsiElement newElement) throws IncorrectOperationException {
        return elem.replace(newElement);
    }

    @Override
    public boolean isValid() {
        return elem.isValid();
    }

    @Override
    public boolean isWritable() {
        return elem.isWritable();
    }

    @Nullable
    @Override
    public PsiReference getReference() {
        return elem.getReference();
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return elem.getReferences();
    }

    @Nullable
    @Override
    public <T> T getCopyableUserData(Key<T> key) {
        return elem.getCopyableUserData(key);
    }

    @Override
    public <T> void putCopyableUserData(Key<T> key, @Nullable T value) {
        elem.putCopyableUserData(key, value);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, @Nullable PsiElement lastParent, @NotNull PsiElement place) {
        return elem.processDeclarations(processor, state, lastParent, place);
    }

    @Nullable
    @Override
    public PsiElement getContext() {
        return elem.getContext();
    }

    @Override
    public boolean isPhysical() {
        return elem.isPhysical();
    }

    @NotNull
    @Override
    public GlobalSearchScope getResolveScope() {
        return elem.getResolveScope();
    }

    @NotNull
    @Override
    public SearchScope getUseScope() {
        return elem.getUseScope();
    }

    @Override
    public ASTNode getNode() {
        return elem.getNode();
    }

    @Override
    public boolean isEquivalentTo(PsiElement another) {
        return elem.isEquivalentTo(another);
    }

    @Nullable
    @Override
    public String getValue() {
        return shapeAttr.getValue();
    }

    @Nullable
    @Override
    public String getDisplayValue() {
        return shapeAttr.getValue();
    }

    @Override
    public int physicalToDisplay(int offset) {
        return 0;
    }

    @Override
    public int displayToPhysical(int offset) {
        return 0;
    }

    @NotNull
    @Override
    public TextRange getValueTextRange() {
        return null;
    }

    @Override
    public boolean isNamespaceDeclaration() {
        return false;
    }

    @Nullable
    @Override
    public XmlAttributeDescriptor getDescriptor() {
        return null;
    }

    @Nullable
    @Override
    public XmlAttributeValue getValueElement() {
        return null;
    }

    @Override
    public void setValue(String value) throws IncorrectOperationException {
        shapeAttr.setValue(value);
    }

    @Override
    public boolean processElements(PsiElementProcessor processor, PsiElement place) {
        return false;
    }

    @Override
    public Icon getIcon(int flags) {
        return elem.getIcon(flags);
    }

    @Nullable
    @Override
    public <T> T getUserData(@NotNull Key<T> key) {
        return elem.getUserData(key);
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {
        elem.putUserData(key, value);
    }
}
