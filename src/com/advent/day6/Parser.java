package com.advent.day6;


import java.util.ArrayList;
import java.util.List;

public class Parser {
    Token currentToken;
    Token peekToken;
    Tokenizer tokenizer;

    List<ExpressionNode> nodelist = new ArrayList<ExpressionNode>();

    public Parser(String input) {
        this.tokenizer = new Tokenizer(input);
        this.nextToken();
        this.nextToken();
    }
    public List<ExpressionNode> parse() {
        while (this.currentToken.type() != TokenType.EOF) {
            this.parseExpression();
        }

        return this.nodelist;
    }

    public void parseExpression() {
        ExpressionType type = (this.currentToken.type() == TokenType.TURN) ? ExpressionType.TURN : ExpressionType.TOGGLE;

        this.nextToken();
        String args = null;
        if (type == ExpressionType.TURN) {
            if (this.currentToken.type() == TokenType.IDENTIFICATOR) {
                args = this.currentToken.value();
            } else {
                System.out.println("Parsing Error");
            }
            this.nextToken();
        };

        int x1 = 0;
        if (this.currentToken.type() != TokenType.INT) {
            System.out.println("Parsing Error");
        } else {
            x1 = Integer.parseInt(this.currentToken.value());
        }

        this.nextToken();

        if (this.currentToken.type() != TokenType.SEPARATOR) {
            System.out.println("Parsing Error");
        }
        this.nextToken();

        int y1 = 0;
        if (this.currentToken.type() != TokenType.INT) {
            System.out.println("Parsing Error");
        } else {
            y1 = Integer.parseInt(this.currentToken.value());
        }
        this.nextToken();

        if (this.currentToken.type() != TokenType.THROUGH) {
            System.out.println("Parsing Error");
        }
        this.nextToken();

        int x2 = 0;
        if (this.currentToken.type() != TokenType.INT) {
            System.out.println("Parsing Error");
        } else {
            x2 = Integer.parseInt(this.currentToken.value());
        }

        this.nextToken();

        if (this.currentToken.type() != TokenType.SEPARATOR) {
            System.out.println("Parsing Error");
        }
        this.nextToken();

        int y2 = 0;
        if (this.currentToken.type() != TokenType.INT) {
            System.out.println("Parsing Error");
        } else {
            y2 = Integer.parseInt(this.currentToken.value());
        }
        this.nextToken();

        if (this.currentToken.type() != TokenType.EOL) {
            System.out.println("Parsing Error");
        }

        this.nextToken();

        ExpressionNode node = new ExpressionNode(type, "test", args, x1, y1, x2, y2);
        this.nodelist.add(node);
    };

    private void nextToken() {
        this.currentToken = this.peekToken;
        this.peekToken = this.tokenizer.nextToken();
    }
}
