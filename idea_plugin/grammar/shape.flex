
package com.shape.idea.lexer;
 
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.shape.idea.psi.ShapeTypes.*;
import static com.shape.idea.parser.ShapeParserDefinition.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import com.intellij.psi.TokenType;

%%

%public
%class ShapeLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

NEWLINE = [\r\n] |\r\n
WHITE_SPACE=[ \t\f]

LINE_COMMENT = "//" [^\r\n]*

LETTER = [:letter:] | "_"
DIGIT =  [:digit:]
HEX_DIGIT = [0-9A-Fa-f]
INT_DIGIT = [0-9]
OCT_DIGIT = [0-7]

IDENT = {LETTER} ({LETTER} | {DIGIT} )*

_DOT_HEAD_NAME = "." {IDENT}
_VIEW_ID_NAME = "#" {IDENT}

NUM_INT = "0" | ([1-9] {INT_DIGIT}*)
NUM_HEX = ("0x" | "0X") {HEX_DIGIT}+
NUM_OCT = "0" {OCT_DIGIT}+

FLOAT_EXPONENT = [eE] [+-]? {DIGIT}+
NUM_FLOAT = ( ( ({DIGIT}+ "." {DIGIT}*) | ({DIGIT}* "." {DIGIT}+) ) {FLOAT_EXPONENT}?) | ({DIGIT}+ {FLOAT_EXPONENT})

ESCAPES = [abfnrtv]

%state MAYBE_SEMICOLON

%%

<YYINITIAL> {
    "|"                                       { return BIT_OR; }

    {LINE_COMMENT}                            { return LINE_COMMENT; }
    "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?  { return BLOCK_COMMENT; }

    {WHITE_SPACE}                             { return WHITE_SPACE; }
    {NEWLINE}+                                { return NEWLINES; }

    "\"" ( [^\"\\\n\r] | "\\" ("\\" | "\"" | {ESCAPES} | [0-8xuU] ) )* "\""? { yybegin(MAYBE_SEMICOLON); return STR; }
    "\'" ( [^\'\\\n\r] | "\\" ("\\" | "\'" | {ESCAPES} | [0-8xuU] ) )* "\'"? { yybegin(MAYBE_SEMICOLON); return STR; }

    "."                                       { return DOT; }
    "{"                                       { return LBRACE; }
    "}"                                       { yybegin(MAYBE_SEMICOLON); return RBRACE; }

    "["                                       { return LBRACK; }
    "]"                                       { yybegin(MAYBE_SEMICOLON); return RBRACK; }

    "("                                       { return LPAREN; }
    ")"                                       { yybegin(MAYBE_SEMICOLON); return RPAREN; }

    ":"                                       { return COLON; }
    ";"                                       { return SEMICOLON; }
    ","                                       { return COMMA; }
    "?"                                       { return QUESTION_MARK; }

    "=="                                      { return EQ; }
    "="                                       { return ASSIGN; }

    "!="                                      { return NOT_EQ; }
    "!"                                       { return NOT; }

    "++"                                      { yybegin(MAYBE_SEMICOLON); return PLUS_PLUS; }
    "+="                                      { return PLUS_ASSIGN; }
    "+"                                       { return PLUS; }

    "--"                                      { yybegin(MAYBE_SEMICOLON); return MINUS_MINUS; }
    "-="                                      { return MINUS_ASSIGN; }
    "-"                                       { return MINUS; }

    "||"                                      { return COND_OR; }
    "|="                                      { return BIT_OR_ASSIGN; }

    "&^="                                     { return BIT_CLEAR_ASSIGN; }
    "&^"                                      { return BIT_CLEAR; }
    "&&"                                      { return COND_AND; }

    "&="                                      { return BIT_AND_ASSIGN; }
    "&"                                       { return BIT_AND; }

    "<<="                                     { return SHIFT_LEFT_ASSIGN; }
    "<<"                                      { return SHIFT_LEFT; }
    "<="                                      { return LTE; }
    "<"                                       { return LT; }

    "^="                                      { return BIT_XOR_ASSIGN; }
    "^"                                       { return BIT_XOR; }

    "*="                                      { return MUL_ASSIGN; }
    "*"                                       { return MUL; }

    "/="                                      { return QUOTIENT_ASSIGN; }
    "/"                                       { return QUOTIENT; }

    "%="                                      { return MOD_ASSIGN; }
    "%"                                       { return MOD; }

    ">>="                                     { return SHIFT_RIGHT_ASSIGN; }
    ">>"                                      { return SHIFT_RIGHT; }
    ">="                                      { return GTE; }
    ">"                                       { return GT; }
    "#"                                       { return ID_SIGN; }

    "??"                                      { return NOTNULL; }

    "null"                                    { return NULL; }

    "true"                                    { return TRUE; }
    "false"                                   { return FALSE; }

    "boolean"                                 { return BOOLEAN; }
    "break"                                   { yybegin(MAYBE_SEMICOLON); return BREAK; }
    "byte"                                    { return BYTE; }
    "case"                                    { return CASE; }
    "char"                                    { return CHAR; }
    "continue"                                { yybegin(MAYBE_SEMICOLON); return CONTINUE; }
    "do"                                      { return DO; }
    "double"                                  { return DOUBLE; }
    "default"                                 { return DEFAULT; }
    "else"                                    { return ELSE; }
    "finally"                                 { return FINALLY; }
    "float"                                   { return FLOAT; }
    "for"                                     { return FOR; }
    "import"                                  { return IMPORT; }
    "use"                                     { return USE; }
    "instanceof"                              { return INSTANCEOF; }
    "int"                                     { return INT; }
    "long"                                    { return LONG; }
    "new"                                     { return NEW; }
    "if"                                      { return IF; }
    "style"                                   { return STYLE; }
    "short"                                   { return SHORT; }
    "switch"                                  { return SWITCH; }
    "return"                                  { return RETURN; }
    "while"                                   { return WHILE; }

    "dp"                                     { return DP; }
    "sp"                                     { return SP; }
    "px"                                     { return PX; }
    "@"                                      { return AT; }

    {IDENT}                                  {  yybegin(MAYBE_SEMICOLON); return IDENTIFIER; }

    {_DOT_HEAD_NAME}                            {  yybegin(MAYBE_SEMICOLON); return DOT_HEAD_NAME; }
    {_VIEW_ID_NAME}                          {  yybegin(MAYBE_SEMICOLON); return VIEW_ID_NAME; }

    {NUM_FLOAT}                              {  yybegin(MAYBE_SEMICOLON); return FLOATI; }
    {DIGIT}+"i"                              {  yybegin(MAYBE_SEMICOLON); return DECIMALI; }
    {NUM_OCT}                                {  yybegin(MAYBE_SEMICOLON); return OCT; }
    {NUM_HEX}                                {  yybegin(MAYBE_SEMICOLON); return HEX; }
    {NUM_INT}                                {  yybegin(MAYBE_SEMICOLON); return INTEGER; }

    .                                        {  return BAD_CHARACTER; }
}

<MAYBE_SEMICOLON> {
    {WHITE_SPACE}                           { return WHITE_SPACE; }
    {NEWLINE}                               { yybegin(YYINITIAL);/* yypushback(yytext().length());*/ return SEMICOLON_SYNTHETIC; }
    {LINE_COMMENT}                          { return LINE_COMMENT; }
    "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")? { return BLOCK_COMMENT; }

    .           { yybegin(YYINITIAL); yypushback(yytext().length()); }
}
