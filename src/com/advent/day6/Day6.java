package com.advent.day6;

import com.advent.FileInputReader;

public class Day6 {
    public static void start() {
        System.out.println("-- Day 6 --");

        String filePath = "\\input\\day6.txt";
        String input = FileInputReader.readWholeInput(filePath);

        executePart1(input);
        executePart2(input);
    }

    static void executePart1(String input) {
        Evaluation evaluation = new Evaluation(input, GridMode.BINARY);
        int count = evaluation.evaluateInput();
        System.out.println("Part 1: " + count);
    }

     static void executePart2(String input) {
        Evaluation evaluation = new Evaluation(input, GridMode.SPECTRUM);
        int count = evaluation.evaluateInput();
        System.out.println("Part 2: " + count);
    }
}
