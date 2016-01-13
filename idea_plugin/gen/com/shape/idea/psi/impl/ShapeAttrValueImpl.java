// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.shape.idea.psi.ShapeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.shape.idea.psi.*;

public class ShapeAttrValueImpl extends ASTWrapperPsiElement implements ShapeAttrValue {

  public ShapeAttrValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitAttrValue(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeAttrIdentValue getAttrIdentValue() {
    return findChildByClass(ShapeAttrIdentValue.class);
  }

  @Override
  @Nullable
  public ShapeAttrStrValue getAttrStrValue() {
    return findChildByClass(ShapeAttrStrValue.class);
  }

  @Override
  @Nullable
  public ShapeColorCode getColorCode() {
    return findChildByClass(ShapeColorCode.class);
  }

  @Override
  @Nullable
  public ShapeDimension getDimension() {
    return findChildByClass(ShapeDimension.class);
  }

  @Override
  @Nullable
  public ShapeFourDirectionAttr getFourDirectionAttr() {
    return findChildByClass(ShapeFourDirectionAttr.class);
  }

  @Override
  @Nullable
  public ShapeResourceReference getResourceReference() {
    return findChildByClass(ShapeResourceReference.class);
  }

}
