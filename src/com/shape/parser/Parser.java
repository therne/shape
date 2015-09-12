package com.shape.parser;

import com.shape.ast.Modifiers;
import com.shape.ast.attributes.*;
import com.shape.ast.nodes.Node;
import com.shape.ast.nodes.View;
import com.shape.ast.styles.Style;
import com.shape.dictionary.TokenType;
import com.shape.error.LessError;
import com.shape.error.SyntaxError;
import com.shape.error.UnexpectedTokenError;
import com.shape.lexer.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shape.dictionary.TokenType.*;

/**
 * Parser
 * Converts tokenized code (by lexer) into Abstract Syntax Tree.
 */
public class Parser extends BaseParser {

    private Style parsingStyle;

    @Override
    protected void expect() throws LessError {
        switch (currToken.getType()) {
            case IMPORT: handleImport(); break;
            case INCLUDE: handleInclude(); break;
            case NAME: viewBegin(); break;
            case STYLE: styleBegin(); break;
            case USE: useBlock(); break;

            default:
                throw new UnexpectedTokenError(currToken);
        }
    }

    @Override
    protected void expectationMatched() throws LessError {
        switch (currentState) {
            case VIEW:
                if (currToken.getType() == NAME) {
                    // if next is comma or close(')'), it is state attribute
                    TokenType next = code.peekNext().getType();
                    if (next == COMMA || next == RPAREN) {
                        handleStateAttribute();
                        if (next == RPAREN) viewEnd();
                        pull();
                        break;
                    }
                    else if (next != COLON) throw new UnexpectedTokenError(currToken);

                    handleAttribute(false);
                    expectNext(NAME, COLON, COMMA, RPAREN);
                }
                else if (currToken.getType() == COMMA) expectNext(NAME, RPAREN);
                else if (currToken.getType() == RPAREN) viewEnd();
                break;

            case VIEW_END:
                if (currToken.getType() == LBRACE) {
                    // visit node
                    nodeStack.push(currentNode);
                    ast.visit(currentNode);

                } else if (currToken.getType() == RBRACE) {
                    // leave this node
                    nodeStack.pop();
                    ast.leave();

                } else if (currToken.getType() == NAME) {
                    // begin of another view
                    viewBegin();
                }
                else throw new UnexpectedTokenError(currToken);
                break;

            case STYLE:
                if (currToken.getType() == NAME) {
                    handleAttribute(true);
                    expectNext(NAME, COLON, SEMICOLON, RBRACE);
                }
                else if (currToken.getType() == SEMICOLON) expectNext(NAME, COLON, RBRACE);
                else if (currToken.getType() == RBRACE) styleEnd();
        }
    }

    void viewBegin() throws SyntaxError {
        String id = null, styleName;

        // Current token is class name.
        View view = new View(currToken.getLexeme());

        // before all, check first name is not whether id or style
        String firstLetter = currToken.getLexeme().substring(0, 1);
        if (".#".contains(firstLetter)) {
            // unexpected # or .
            currToken.setLexeme(firstLetter);
            throw new UnexpectedTokenError(currToken);
        }

        // find id and style
        while (expectAndPull(NAME, LPAREN).getType() != LPAREN) {
            String current = currToken.getLexeme();
            if (current.startsWith("#")) {
                if (id != null) throw new SyntaxError("id must be unique", currToken);
                id = current.substring(1);
            }
            else if (current.startsWith(".")) {
                styleName = current.substring(1);

                // search for style
                Style style = source.getStyle(styleName);
                if (style != null) view.applyStyle(style);
                else {
                    // TODO: 뷰 뒤에 스타일이 선언되어있을 경우를 고려 - 무조건 리소스 취급하고 예외처리하면 안됨.
                    // not shape style. it would be Android style resources
                    if (view.getStyleResourceName() != null)
                        throw new SyntaxError("you must assign one style resource at one view.", currToken);

                    view.setStyleResourceName(styleName);
                }
            }
        }

        if (id != null) view.setId(id);

        // Add view to the AST
        view.setParent(nodeStack.size() == 0 ? null : nodeStack.lastElement());
        currentNode = view;

        setState(ParsingState.VIEW);
        expectNext(NAME, RPAREN);
    }

    void viewEnd() {
        // add this view to AST
        ast.addNode(currentNode);

        setState(ParsingState.VIEW_END);
        expectNext(NAME, LBRACE, RBRACE);
    }

    void handleImport() throws LessError {
        // import must be top of the layer. not in the View block.
        if (!nodeStack.isEmpty()) throw new SyntaxError("import must be top", currToken);

        // get import target (module name)
        Token targetName = expectAndPull(LITERAL_STRING);

        // TODO: IMPORT!
    }

    void handleInclude() throws LessError {
        // include must be in the view or layout block.
        if (nodeStack.isEmpty()) throw new SyntaxError("'include' must be in the View or Layout.", currToken);

        // TODO: INCLUDE!
    }

    void useBlock() throws LessError {
        Token next = expectAndPull(NAME, LBRACE);
        if (next.getType() == NAME) {

        }
    }

    void useBlockField() throws LessError {

    }

    void styleBegin() throws LessError {
        //TODO: 범위한정

        // get name
        String name = expectAndPull(NAME).getLexeme();
        parsingStyle = new Style(name);

        // round bracket: selector, brace: just style
        Token next = expectAndPull(LPAREN, LBRACE);
        if (next.getType() == LPAREN) {
            setState(ParsingState.STYLE_SELECTOR);
            expectNext(NAME, RPAREN);

        } else {
            setState(ParsingState.STYLE);
            expectNext(NAME, RBRACE);
        }
    }

    void styleEnd() {
        source.addStyle(parsingStyle);
        expectNext();
    }


    void handleAttribute(boolean isStyle) throws LessError {
        String attrKey = currToken.getLexeme();

        // move cursor to the value part
        pull();
        pull();

        // Add attribute to style or view node.
        Node addTo = isStyle ? parsingStyle : currentNode;

        // Resource Reference (@[package:]type/resourceName)
        if (currToken.getType() == NAME && (currToken.getLexeme().startsWith("@") || currToken.getLexeme().startsWith("?"))) {
            handleResourceRef(addTo, attrKey);
        }

        // or Dimension (dp, %)
        else if (currToken.getType() == NUMBER || currToken.getType() == OLD_DOUBLE) {
            handleDimension(addTo, attrKey);

        } else handleOtherAttribute(addTo, attrKey);
   }


    void handleResourceRef(Node node, String attrKey) throws SyntaxError {
        String resType = currToken.getLexeme(); // ex) @string, ?attr, ...
        expectAndPull(QUOTIENT);  // /
        expectAndPull(NAME); // value

        node.addAttribute(new ResourceAttribute(attrKey, resType, currToken.getLexeme()));
    }

    void handleDimension(Node node, String attrKey) throws SyntaxError {
        Token value = currToken;

        // TODO: 하드코딩 나빠효.
        if (attrKey.equals("padding") || attrKey.equals("margin")) {
            parseDirectionalAttribute(node, attrKey, value);
            return;
        }

        expectAndPull(MOD, UNIT);

        // unit - dp, px, sp...
        if (currToken.getType().isInCategory(UNIT)) {
            node.addAttribute(new DimensionAttribute(attrKey, value, currToken));
        }

        // percent (%) : weight
        else if (currToken.getType() == MOD) {
            node.addAttribute(new LayoutParam(attrKey, "wrap"));

            double percentage = Double.valueOf(value.getLexeme());
            if (percentage == 0 || percentage > 100)
                throw new SyntaxError("percentage out of bound : " + percentage + "%.", currToken.getLineNo(), currToken.getColNo());

            Attribute weightAttr = new Attribute("weight", value.getLexeme());
            weightAttr.addModifier(Modifiers.weightModifier());
            weightAttr.addModifier(v -> {
                View parent = (View) v.getParent();
                if (parent != null) parent.addAttribute(new Attribute("weightSum", "100"));
            });
            node.addAttribute(weightAttr);
        }
    }


    // TODO: WIP
    private static final String[] DIRECTION_ORDER = {"Top", "Left", "Bottom", "Right"};
    private static final List<TokenType> ALLOWED = Arrays.asList(RBRACE, COMMA, OLD_DOUBLE, NUMBER);
    void parseDirectionalAttribute(Node node, String key, Token firstValue) throws SyntaxError {
        // first, add top
        ArrayList<Token> values = new ArrayList<>(4),
                units = new ArrayList<>(4);

        values.add(firstValue);
        if (code.peekNext().isInCategory(UNIT)) units.add(code.next());
        else if (ALLOWED.contains(code.peekNext().getType())) units.add(null);
        else throw new UnexpectedTokenError(code.peekNext());

        while (code.peekNext().getType() != RPAREN && code.peekNext().getType() != COMMA && code.peekNext().getType() != RBRACE
                && !(code.peekNext().getType() == NAME && !code.peekNext().isInCategory(UNIT))) {
            values.add(expectAndPull(NUMBER, OLD_DOUBLE)); // value

            if (code.peekNext().isInCategory(UNIT)) units.add(code.next());
            else if (ALLOWED.contains(code.peekNext().getType())) units.add(null);
            else throw new UnexpectedTokenError(code.peekNext());
        }

        // just one value margin or padding (applied to all directions by default)
        if (values.size() == 1) {
            if (units.get(0) == null) throw new SyntaxError("you must give unit! (dp, sp, px...)",
                    firstValue.getLineNo(), firstValue.getColNo());
            node.addAttribute(new DimensionAttribute(key, firstValue, units.get(0)));
        }

        // check any unit exists
        boolean hasUnit = false;
        for (Token unit : units) {
            if (unit != null) hasUnit = true;
        }
        if (!hasUnit) throw new SyntaxError("you must give at least one unit! (dp, sp, px...)",
                firstValue.getLineNo(), firstValue.getColNo());

        int len = values.size();
        Token globalUnit = units.get(units.size()-1);
        if (hasUnit && globalUnit == null) {
            Token lastValue = values.get(len-1);
            throw new SyntaxError("you must give unit at last dimension. (dp, sp, px..)",
                    lastValue.getLineNo(), lastValue.getColNo()); // TODO: lastValue
        }

        for (int i=0; i<len; i++) {
            node.addAttribute(new DimensionAttribute(key + DIRECTION_ORDER[i], values.get(i),
                units.get(i) != null ? units.get(i) : globalUnit));
        }
    }
    void handleOtherAttribute(Node node, String attrKey) throws SyntaxError {
        String value = currToken.getLexeme();
        Attribute attr;

        // determine attribute type
        switch(attrKey) {
            case "font":
                attr = new FontAttribute(value);
                break;

            case "width":
            case "height":
                attr = new LayoutParam(attrKey, value);
                break;

            case "weight":
                // Apply Modifier for optimization (layout_height=0dp)
                attr = new Attribute(attrKey, value);
                attr.addModifier(Modifiers.weightModifier());
                break;

//              case "margin":
//              case "padding":
//
//                  break;

            default:
                attr = new Attribute(attrKey, value);
                break;
        }
        node.addAttribute(attr);
    }

    void handleStateAttribute() throws SyntaxError {
        Attribute attr;

        switch (currToken.getLexeme()) {
            case "vertical":    attr = new Attribute("orientation", "vertical"); break;
            case "horizontal":  attr = new Attribute("orientation", "horizontal"); break;
            case "editable":    attr = new Attribute("editable", "true"); break;
            case "visible":     attr = new Attribute("visibility", "visible"); break;
            case "invisible":   attr = new Attribute("visibility", "invisible"); break;
            case "focusable":   attr = new Attribute("focusable", "true"); break;
            case "clickable":   attr = new Attribute("clickable", "true"); break;
            default: throw new SyntaxError("no state attribute found : " + currToken.getLexeme(), currToken);
        }
        currentNode.addAttribute(attr);
    }
}
