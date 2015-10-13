package com.shape.idea.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.shape.idea.ShapeLanguage;
import com.shape.idea.lexer.ShapeLexerAdapter;
import com.shape.idea.psi.ShapeFile;
import com.shape.idea.psi.ShapeTokenType;
import com.shape.idea.psi.ShapeTypes;
import org.jetbrains.annotations.NotNull;

import static com.shape.idea.psi.ShapeTypes.*;

public class ShapeParserDefinition implements com.intellij.lang.ParserDefinition {

    public static final IElementType LINE_COMMENT = new ShapeTokenType("SHAPE_LINE_COMMENT");
    public static final IElementType BLOCK_COMMENT = new ShapeTokenType("SHAPE_BLOCK_COMMENT");

    public static final IElementType WHITE_SPACE = new ShapeTokenType("SHAPE_WHITE_SPACE");
    public static final IElementType NEWLINES = new ShapeTokenType("SHAPE_NEWLINES");

    public static final TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE, NEWLINES);
    public static final TokenSet COMMENTS = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT);
    public static final TokenSet STRING_LITERALS = TokenSet.create(STR);
    public static final TokenSet NUMBERS = TokenSet.create(INTEGER, FLOATI, DECIMALI, FLOATI, HEX, OCT);
    public static final TokenSet KEYWORDS = TokenSet.create(BOOLEAN, BREAK, BYTE, CASE, CHAR,
            CONTINUE, DO, DOUBLE, ELSE, FINALLY, FLOAT, FOR, DEFAULT, IMPORT, USE, INSTANCEOF, INT,
            LONG, NEW, IF, STYLE, SHORT, SWITCH, RETURN, WHILE);

    public static final TokenSet OPERATORS = TokenSet.create(QUESTION_MARK,
            EQ, ASSIGN, NOT_EQ, NOT, PLUS_PLUS, PLUS_ASSIGN, PLUS, MINUS_MINUS, MINUS_ASSIGN, MINUS,
            COND_OR, BIT_OR_ASSIGN, BIT_CLEAR, BIT_CLEAR_ASSIGN, COND_AND, BIT_AND, BIT_AND_ASSIGN,
            SHIFT_LEFT, SHIFT_LEFT_ASSIGN, SHIFT_RIGHT, SHIFT_RIGHT_ASSIGN, LTE, LT, GTE, GT, COLON,
            BIT_XOR, BIT_XOR_ASSIGN, MUL, MUL_ASSIGN, QUOTIENT, QUOTIENT_ASSIGN, MOD, MOD_ASSIGN, ID_SIGN, NOTNULL);
 
    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(ShapeLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ShapeLexerAdapter();
    }
 
    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }
 
    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }
 
    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRING_LITERALS;
    }
 
    @NotNull
    public PsiParser createParser(final Project project) {
        return new ShapeParser();
    }
 
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }


    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ShapeFile(viewProvider);
    }
 
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
 
    @NotNull
    public PsiElement createElement(ASTNode node) {
        return ShapeTypes.Factory.createElement(node);
    }
}