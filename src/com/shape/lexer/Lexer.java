package com.shape.lexer;

import com.shape.error.LessError;
import com.shape.error.SyntaxError;
import com.shape.dictionary.Operator;
import com.shape.dictionary.TokenType;

import java.io.*;
import java.util.Stack;

/**
 * Lexically analyses the code, and tokenizes, and returns tokenized code.
 */
public class Lexer {
    private File sourceFile;
    private TokenStream code = new TokenStream();
    private TokenType currentlyParsing;
    private boolean expectingNext = false;
    private Stack<Character> blockStack = new Stack<>();
    private StringBuilder tokenStack = new StringBuilder();
    private int lineNo = 0, colNo = 0;


    public Lexer(File sourceFile) {
        this.sourceFile = sourceFile;
        this.currentlyParsing = null;
    }

    /**
     * Perform lexical analysis.
     *
     * @return tokenized code
     */
    public TokenStream perform() throws LessError {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

            String line;
            while ((line = reader.readLine()) != null) analyze(line);

            // finish last token
            tokenize(currentlyParsing);

            // didn't I closed some brackets?
            if (blockStack.size() != 0) {
                throw new SyntaxError("'" + blockStack.pop() + "' expected : bracket is not closed.", lineNo, colNo);
            }

        } catch (FileNotFoundException e) {
            throw new LessError("File not found.");

        } catch (IOException e) {
            throw new LessError("An error occured during reading file. (%s)", e.getMessage());
        }
        return code;
    }

    /**
     * Do analyze.
     */
    private void analyze(String line) throws LessError {
        line += '\n';

        // increase line num
        ++lineNo;

        for (colNo = 1; colNo <= line.length(); colNo++) {
            char ch = line.charAt(colNo - 1);
            TokenType thisType = getTokenType(ch);

            // Skip blank (space, tab)
            if (currentlyParsing == null && thisType == currentlyParsing) continue;

//            if (thisType != null) {
//                Log.debug("Line %d, col %d\t| %s\t\t%c current=%s", lineNo, colNo, thisType.toString(), ch, currentlyParsing == null ? "null" : currentlyParsing.toString());
//            } else Log.debug("Line %d, col %d\t|", lineNo, colNo);

            // Convert floating point to literal double.
            if (currentlyParsing == TokenType.NUMBER && thisType == TokenType.DOT) {
                currentlyParsing = TokenType.OLD_DOUBLE;
            }

            // Parsing litteral string.
            else if (currentlyParsing == TokenType.LITERAL_STRING) {
                if (Operator.isQuotationMark(ch) && topInBlockStack() == ch) {
                    // close the string block!
                    blockStack.pop();
                    tokenStack.deleteCharAt(0); // remove start
                    tokenize(currentlyParsing);
                    continue;

                } else if (ch == '\\') {
                    // probably next will be escape character!
                    expectingNext = true;
                    continue;

                } else if (expectingNext) {
                    ch = convertToEscapeChar(ch);
                    expectingNext = false;
                }
            }

            // Comments
            else if (currentlyParsing == TokenType.LINE_COMMENT) continue;
            else if (currentlyParsing == TokenType.BLOCK_COMMENT) {
                // closable?
                if (ch == '*') expectingNext = true;
                else if (expectingNext && ch == '/') {
                    // close block comment
                    expectingNext = false;
                    currentlyParsing = null;

                } else expectingNext = false;
                continue;
            } else if ("/".equals(tokenStack.toString())) {
                tokenStack = new StringBuilder();

                // It could be begin comments
                if (thisType == TokenType.QUOTIENT) {
                    currentlyParsing = TokenType.LINE_COMMENT;

                } else if (thisType == TokenType.MUL) {
                    currentlyParsing = TokenType.BLOCK_COMMENT;
                }
                // or just a divide operator...
                else {
                    tokenize(TokenType.QUOTIENT);
                    tokenStack.append(ch);
                    currentlyParsing = thisType;
                }
                continue;
            }
            // I was parsing some token but faced OPERATOR?
            else if (thisType != null && thisType.isOperator()) {
                // tokenize old
                tokenize(currentlyParsing);

                // It's a block? close it.
                if (Operator.isEndBlock(ch) && topInBlockStack() == ch) {
                    blockStack.pop();
                }

                // DO NOT begin into operator - just make it instantly..... except COMMENTS!
                if (thisType == TokenType.QUOTIENT) {
                    tokenStack.append(ch);
                    continue;
                }
                tokenize(thisType);
                continue;
            }
            // I was parsing some token but faced DIFFERENT token?
            else if (currentlyParsing != thisType) {
                // tokenize old
                tokenize(currentlyParsing);

                // begin new token
                currentlyParsing = thisType;

                // Is it block (including string "" block) begin?
                if (Operator.isBeginBlock(ch)) blockStack.add(ch);
            }
            tokenStack.append(ch);
        }

        // enter newline
        newline();
    }

    private void newline() throws SyntaxError {
        // ERROR: Was I expecting next but line is ended?
        if (expectingNext) {
            throw new SyntaxError("Unexpected line ending", lineNo, colNo);
        }

        // ERROR: String is not closed?
        if (currentlyParsing == TokenType.LITERAL_STRING) {
            throw new SyntaxError("Illegal line end of string", lineNo, colNo);
        }

        // Disable line comment
        if (currentlyParsing == TokenType.LINE_COMMENT) currentlyParsing = null;
    }

    private TokenType getTokenType(char ch) {
        if (ch == ' ' || ch == '\t') {
            // Space and tab is not a token.
            return null;

        } else if (Character.isDigit(ch)) {
            // return double if current types is already changed to double.
            return (currentlyParsing == TokenType.OLD_DOUBLE ? TokenType.OLD_DOUBLE : TokenType.NUMBER);

        } else if (Character.isLetterOrDigit(ch) || Operator.isNameAllowedOperator(ch)) {
            return TokenType.NAME;

        } else if (Operator.isQuotationMark(ch)) {
            return TokenType.LITERAL_STRING;

        } else if (Operator.isOperator(ch)) {
            // determine detail token types
            return TokenType.get(Character.toString(ch));

        } else if (ch == '\n') {
            // line feed - ignored. not important.
            return null;
        }
        return TokenType.UNKNOWN;
    }

    private char topInBlockStack() {
        return blockStack.size() == 0 ? '\0' : blockStack.lastElement();
    }

    private char convertToEscapeChar(char ch) throws SyntaxError {
        switch (ch) {
            case '0':
                return '\0';
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 't':
                return '\t';
            case 'r':
                return '\r';
            case 'n':
                return '\n';
            case '\\':
                return '\\';
        }
        // WTF
        throw new SyntaxError("Illegal escape character : " + ch, lineNo, colNo);
    }

    /**
     * Finishes particular token parsing and adds token to TokenizedCode.
     */
    private void tokenize(TokenType type) {
        if (type == null) {
            tokenStack = new StringBuilder();
            return;
        }

//        Log.debug("    >>>> Tokenizer : types=%s tokenStack=%s", type.toString(), tokenStack.toString());

        if (type == TokenType.NAME) {
            // try to find from keywords
            type = TokenType.get(tokenStack.toString());
            if (type == null) type = TokenType.NAME;
        }

        Token token;
        // add lexeme if literal
        if (type.isLitteral() || type == TokenType.NAME)
            token = new Token(type, tokenStack.toString());
        else token = new Token(type);

        token.setCodeOffsetInformation(lineNo, colNo - token.getLexeme().length());

        code.add(token);
        currentlyParsing = null;
        tokenStack = new StringBuilder();
    }
}

