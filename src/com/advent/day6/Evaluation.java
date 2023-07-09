package com.advent.day6;

import java.util.Arrays;
import java.util.List;

enum GridMode {
    BINARY,
    SPECTRUM
};
public class Evaluation {
    String input;
    int[][] grid = new int[1000][1000];

    GridMode mode;
    public Evaluation(String input, GridMode mode) {
        this.mode = mode;
        this.initGrid();
        this.input = input;
    }

    private void initGrid() {
        for (int col = 0; col < 1000; col++) {
            for (int row = 0; row < 1000; row++) {
                this.grid[col][row] = 0;
            }
        }
    }
    public int evaluateInput() {
        Parser parser = new Parser(this.input);
        List<ExpressionNode> nodeList = parser.parse();
        if (this.mode == GridMode.BINARY) {
            nodeList.forEach(this::evaluateBinary);
        } else {
            nodeList.forEach(this::evaluateSpectrum);
        }

        int count = this.countLight();
        return count;
    }

    private int countLight() {
        int result = 0;
        for (int col = 0; col < 1000; col++) {
            for (int row = 0; row < 1000; row++) {
                result = result + this.grid[col][row];
            }
        }

        return result;
    }

    private void evaluateBinary(ExpressionNode node) {
        if (node.type() == ExpressionType.TURN) {
            int value = (node.arg().equals("on")) ? 1 : 0;

            for (int col = node.y1(); col <= node.y2(); col++) {
                for (int row = node.x1(); row <= node.x2(); row++) {
                    this.grid[col][row] = value;
                }
            }
        }

        if (node.type() == ExpressionType.TOGGLE) {
            for (int col = node.y1(); col <= node.y2(); col++) {
                for (int row = node.x1(); row <= node.x2(); row++) {
                    int current = this.grid[col][row];
                    this.grid[col][row] = (current == 0) ? 1 : 0;
                }
            }
        }
    }

    private void evaluateSpectrum(ExpressionNode node) {
        int diff = 0;
        if (node.type() == ExpressionType.TURN) {
            diff = (node.arg().equals("on")) ? 1 : -1;
        }
        if (node.type() == ExpressionType.TOGGLE) {
            diff = 2;
        }

        for (int col = node.y1(); col <= node.y2(); col++) {
            for (int row = node.x1(); row <= node.x2(); row++) {
                int current = this.grid[col][row];
                int newValue = current + diff;
                if (newValue < 0) {
                    this.grid[col][row] = 0;
                } else {
                    this.grid[col][row] = newValue;
                }
            }
        }
    }
}
