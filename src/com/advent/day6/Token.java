package com.advent.day6;

public record Token (TokenType type, String value) {}

enum TokenType {
    TOGGLE,
    TURN,
    THROUGH,
    IDENTIFICATOR,
    SPACE,
    SEPARATOR,
    ILLEGAL,
    ARG,
    INT,
    EOL,
    EOF,
}
