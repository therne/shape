package com.shape.dictionary;

public class Operator {
    private static final String OPERATORS = "{}[]()!@%^=-*/<>|?,;:.#";
    private static final String NAME_ALLOWED_OPERATORS = "._$@?#";
    private static final String OPERATOR_BEGIN = "\"'({[";
    private static final String OPERATOR_END = "\"')}]";

    public static boolean isOperator(int ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public static boolean isNameAllowedOperator(int ch) {
        return NAME_ALLOWED_OPERATORS.indexOf(ch) != -1;
    }

    public static boolean isQuotationMark(int ch) {
        return ch == '"' || ch == '\'';
    }

    public static boolean isBeginBlock(int ch) {
        return OPERATOR_BEGIN.indexOf(ch) != -1;
    }

    public static boolean isEndBlock(int ch) {
        return OPERATOR_END.indexOf(ch) != -1;
    }
}
