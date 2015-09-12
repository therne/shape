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

public class ShapeAttributeImpl extends ASTWrapperPsiElement implements ShapeAttribute {

  public ShapeAttributeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitAttribute(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeAttributePair getAttributePair() {
    return findChildByClass(ShapeAttributePair.class);
  }

  @Override
  @Nullable
  public ShapeStateAttribute getStateAttribute() {
    return findChildByClass(ShapeStateAttribute.class);
  }

}
