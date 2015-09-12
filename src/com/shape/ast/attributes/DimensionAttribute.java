package com.shape.ast.attributes;

import com.shape.dictionary.TokenType;
import com.shape.error.SyntaxError;
import com.shape.lexer.Token;

public class DimensionAttribute extends ResourceAttribute {
    private Integer valueI;
    private Double valueD;
    private Token type;

    public DimensionAttribute(String key, String resourceType, String resourceName) throws SyntaxError {
        super(key, resourceType, resourceName);
        if (!this.resourceType.equals("dimen")) {
            // TODO: raise syntax error if not @dimen
//          throw new SyntaxError("Only dimension resource");
        }
    }

    public DimensionAttribute(String key, Token value, Token typeToken) {
        super(key, ""); // will fill value later
        this.type = typeToken;

        if (value.getType() == TokenType.NUMBER) {
            this.valueI = Integer.parseInt(value.getLexeme());
            this.value = valueI + typeToken.getLexeme();

        } else if (value.getType() == TokenType.OLD_DOUBLE) {
            this.valueD = Double.parseDouble(value.getLexeme());
            this.value = valueD + typeToken.getLexeme();
        }
    }
}
