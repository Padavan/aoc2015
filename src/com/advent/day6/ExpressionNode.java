package com.advent.day6;

enum ExpressionType {
    TURN,
    TOGGLE
};
public record ExpressionNode(ExpressionType type, String value, String arg, int x1, int y1, int x2, int y2) {}
