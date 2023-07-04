package com.advent.day6;

import com.advent.FileInputReader;

import java.util.ArrayList;

//turn on 0,0 through 999,999
//toggle 0,0 through 999,0
//turn off 499,499 through 500,500

public class Day6 {
    public static void start() {
        System.out.println("-- Day 6 --");

        String filePath = "\\input\\day6.txt";
        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        executePart1(lineData);
//        part1
    }

    static String[] tokenizer(String command) {
        return command.split(" ");
    }
    static void executePart1(ArrayList<String> multiLineData) {
        System.out.println(multiLineData.toArray().length);

        String testString1 = "turn on 0,0 through 999,999";
        String testString2 = "turn off 301,3 through 808,453";
        String testString3 = "turn on 351,678 through 951,908";
        String testString4 = "toggle 720,196 through 897,994";
        String[] tokens = tokenizer(testString1);

//        Parser.parse(tokens);
    }
}

//public class Node {
//    String type;
//    String operation;
//}