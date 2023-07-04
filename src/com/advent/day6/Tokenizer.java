package com.advent.day6;

public class Tokenizer {
    String input;

    int position = 0; // current position in input (points to current char)
    int readPosition = 1; // current reading position in input (after current char)
    Character ch; // current char under examination
    Token currentToken;
    public Tokenizer(String input) {
        this.input = input;
        this.ch = input.charAt(0);
    }

    public Token nextToken() {

        switch (this.ch) {
            case ' ':
                this.readChar();
                this.currentToken = this.nextToken();
                break;
            case ',':
                this.currentToken = new Token(TokenType.SEPARATOR, ",");
                this.readChar();
                break;
            case '\n':
                this.currentToken = new Token(TokenType.EOL, "newline");
                this.readChar();
                break;
            case '0':
                this.currentToken = new Token(TokenType.EOF, "");
                break;
            default:
                if (this.isLetter(this.ch)) {
                    this.currentToken = this.readIdentifier();
                } else if (this.isNumber(this.ch)) {
                    this.currentToken = this.readNumber();
                } else {
                    this.currentToken = new Token(TokenType.ILLEGAL, this.ch.toString());
                }
        }

        return this.currentToken;
    };

    private Token readIdentifier() {
        int startPosition = this.position;
        while (this.isLetter(this.ch)) {
            this.readChar();
        }
        String word = this.input.substring(startPosition, this.position);
        return switch (word) {
            case "toggle" -> new Token(TokenType.TOGGLE, "toggle");
            case "turn" -> new Token(TokenType.TURN, "turn");
            case "through" -> new Token(TokenType.THROUGH, "through");
            default -> new Token(TokenType.IDENTIFICATOR, word);
        };
    }

    private Token readNumber() {
        int startPosition = this.position;
        while (this.isNumber(this.ch)) {
            this.readChar();
        }
        String number = this.input.substring(startPosition, this.position);
        return new Token(TokenType.INT, number);
    }

    public void readChar() {
        if (this.readPosition >= this.input.length()) {
            this.ch = '0';
        } else {
            this.ch = this.input.charAt(this.readPosition);
        };

        this.position = this.readPosition;
        this.readPosition = this.readPosition + 1;
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z');
    }
    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
