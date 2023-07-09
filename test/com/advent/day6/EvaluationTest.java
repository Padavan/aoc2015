package com.advent.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {

    @Test
    void evaluatePart1InputTurn() {
        String adventExample = "turn on 0,0 through 999,999\n";
        Evaluation evaluation = new Evaluation(adventExample, GridMode.BINARY);
        int count = evaluation.evaluateInput();
        assertEquals(count, 1000000);
    }

    @Test
    void evaluatePart1InputToggle() {
        String adventExample = "toggle 0,0 through 999,0\n";
        Evaluation evaluation = new Evaluation(adventExample, GridMode.BINARY);
        int count = evaluation.evaluateInput();
        assertEquals(count, 1000);
    }

    @Test
    void evaluatePart1InputTurnMiddle() {
        String adventExample = "turn on 499,499 through 500,500\n";
        Evaluation evaluation = new Evaluation(adventExample, GridMode.BINARY);
        int count = evaluation.evaluateInput();
        assertEquals(count, 4);
    }

    @Test
    void evaluatePart2InputTurn() {
        String adventExample = "turn on 0,0 through 0,0\n";
        Evaluation evaluation = new Evaluation(adventExample, GridMode.SPECTRUM);
        int count = evaluation.evaluateInput();
        assertEquals(count, 1);
    }

    @Test
    void evaluatePart2InputToggle() {
        String adventExample = "toggle 0,0 through 999,999\n";
        Evaluation evaluation = new Evaluation(adventExample, GridMode.SPECTRUM);
        int count = evaluation.evaluateInput();
        assertEquals(count, 2000000);
    }
}