package com.advent.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TokenizerTest {

    @Test
    void Should_correct_tokenize_separator() {
        Tokenizer tokenizer = new Tokenizer(",");
        Token token = tokenizer.nextToken();
        assertEquals(token.type(), TokenType.SEPARATOR);
    }

    @Test
    void Should_correct_tokenize_turn() {
        Tokenizer tokenizer = new Tokenizer("turn");
        Token token = tokenizer.nextToken();
        assertEquals(token.type(), TokenType.TURN);
    }

    @Test
    void Should_correct_tokenize_newline() {
        Tokenizer tokenizer = new Tokenizer("\n");
        Token token = tokenizer.nextToken();
        assertEquals(token.type(), TokenType.SEPARATOR);
    }

    @Test
    void Should_tokenize_entire_command() {
        Tokenizer tokenizer = new Tokenizer("turn on 887,9 through 959,629\n");
        TokenType[] expectedList = {
            TokenType.TURN,
            TokenType.IDENTIFICATOR,
            TokenType.INT,
            TokenType.SEPARATOR,
            TokenType.INT,
            TokenType.THROUGH,
            TokenType.INT,
            TokenType.SEPARATOR,
            TokenType.INT,
            TokenType.EOL,
            TokenType.EOF
        };

        for (TokenType expectedTokenType : expectedList) {
            Token token = tokenizer.nextToken();
            assertEquals(token.type(), expectedTokenType);
        }
    }
}