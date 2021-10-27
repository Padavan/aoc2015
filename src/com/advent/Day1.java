package com.advent;

import java.util.ArrayList;

public class Day1 {

    public static void start() {
        System.out.println("-- Day 1 --");

        String filePath = "\\input\\day1.txt";
        ArrayList<String> lineData = FileInputReader.readInput(filePath);
        char[] charArray = lineData.get(0).toCharArray();

        System.out.println("Part 1: " + part1(charArray));
        System.out.println("Part 2: " + part2(charArray));
    }

    public static int part1(char[] charArray) {
        int currentFloor = 0;

        int i;
        for (i=0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '(' -> currentFloor = currentFloor + 1;
                case ')' -> currentFloor = currentFloor - 1;
                default -> {
                }
            }
        }

        return currentFloor;
    }

    public static int part2(char[] charArray) {
        int currentFloor = 0;

        int i;
        for (i=0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '(' -> currentFloor = currentFloor + 1;
                case ')' -> currentFloor = currentFloor - 1;
                default -> {
                }
            }

            if (currentFloor == -1) {
                return i+1;
            }
        }

        return i;
    }
}