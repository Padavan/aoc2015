package com.advent.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void Should_parse() {
        Parser parser = new Parser("turn on 887,9 through 959,629 \n");
        List<ExpressionNode> result = parser.parse();

        assertEquals(result.get(0).type(), ExpressionType.TURN);
        assertEquals(result.get(0).arg(), "on");
        assertEquals(result.get(0).x1(), 887);
    }

    @Test
    void Should_parse_more_expressions() {
        Parser parser = new Parser("turn on 887,9 through 959,629 \ntoggle 69,610 through 420,422\n");
        List<ExpressionNode> result = parser.parse();

        assertEquals(result.get(1).type(), ExpressionType.TOGGLE);
        assertEquals(result.get(1).x2(), 420);
        assertEquals(result.get(1).x1(), 69);
    }
}