package com.advent.day6;


public class Parser {
    Token currentToken;
    Token peekToken;
    Tokenizer tokenizer;

    ExpressionNode[] nodelist;

    public Parser(String input) {
        this.tokenizer = new Tokenizer(input);
        this.nextToken();
        this.nextToken();
    }
    public ExpressionNode[] parse() {
        if (this.currentToken.type() == TokenType.EOF) {
            System.out.println("EOF");
        }

        return this.nodelist;
    }

    private void nextToken() {
        this.currentToken = this.peekToken;
        this.peekToken = this.tokenizer.nextToken();
    }


}
