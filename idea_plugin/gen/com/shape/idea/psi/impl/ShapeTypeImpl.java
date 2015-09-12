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

public class ShapeTypeImpl extends ASTWrapperPsiElement implements ShapeType {

  public ShapeTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitType(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeType getType() {
    return findChildByClass(ShapeType.class);
  }

  @Override
  @NotNull
  public ShapeTypeSpecifier getTypeSpecifier() {
    return findNotNullChildByClass(ShapeTypeSpecifier.class);
  }

}
