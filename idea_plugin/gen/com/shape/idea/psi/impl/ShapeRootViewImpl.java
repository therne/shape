// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.shape.idea.psi.ShapeTypes.*;
import com.shape.idea.psi.*;

public class ShapeRootViewImpl extends ShapeViewImpl implements ShapeRootView {

  public ShapeRootViewImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitRootView(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ShapeIdDefinition> getIdDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ShapeIdDefinition.class);
  }

  @Override
  @NotNull
  public List<ShapeStyleReference> getStyleReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ShapeStyleReference.class);
  }

  @Override
  @NotNull
  public ShapeViewAttributeBlock getViewAttributeBlock() {
    return findNotNullChildByClass(ShapeViewAttributeBlock.class);
  }

  @Override
  @Nullable
  public ShapeViewBlock getViewBlock() {
    return findChildByClass(ShapeViewBlock.class);
  }

  @Override
  @NotNull
  public ShapeViewName getViewName() {
    return findNotNullChildByClass(ShapeViewName.class);
  }

}
