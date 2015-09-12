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

public class ShapeVariableDeclarationImpl extends ASTWrapperPsiElement implements ShapeVariableDeclaration {

  public ShapeVariableDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitVariableDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ShapeAssignStatement> getAssignStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ShapeAssignStatement.class);
  }

  @Override
  @NotNull
  public ShapeType getType() {
    return findNotNullChildByClass(ShapeType.class);
  }

  @Override
  @NotNull
  public List<ShapeVariableName> getVariableNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ShapeVariableName.class);
  }

}
