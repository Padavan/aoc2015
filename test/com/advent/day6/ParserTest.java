package com.advent.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void Should_parse() {
        Parser parser = new Parser("turn on 887,9 through 959,629 \n");
        ExpressionNode[] result = parser.parse();

        assertEquals(result[0].type(), ExpressionType.TURN);
        assertEquals(result[0].arg(), "on");
        assertEquals(result[0].x1(), 887);
    }
}