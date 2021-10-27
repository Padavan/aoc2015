package com.advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {
    public static void start() {
        System.out.println("-- Day 5 --");

        String filePath = "\\input\\day5.txt";
        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        executePart1(lineData);
        executePart2(lineData);
    }

//    static boolean validateVowelsRule(String abc) {
//        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
//
//        return vowels.stream().filter(c -> abc.indexOf(c) != -1).collect(Collectors.toList()).size() > 3;
//    }

    static boolean validateVowelsRule(String abc) {
        String vowels = "aeiou";
        return abc.chars()
                .mapToObj(i -> (char)i)
                .filter(c -> vowels.indexOf(c) != -1)
                .collect(Collectors.toList())
                .size() >= 3;
    }

    static boolean stutterRule(String abc) {
        for (int i = 1; i < abc.length(); i++) {
            if (abc.charAt(i) == abc.charAt(i-1)) {
                return true;
            }
        }

        return false;
    }

    static boolean notABRule(String abc) {
        List<String> pairs = Arrays.asList("ab", "cd", "pq", "xy");
        return pairs.stream().filter(p -> abc.indexOf(p) != -1).collect(Collectors.toList()).size() == 0;
    }

    static boolean anyPairRule(String abc) {
        for (int i = 1; i < abc.length() - 1; i++) {
            String pair = abc.substring(i-1, i+1);
            String subAbc = abc.substring(i + 1, abc.length());
            if (subAbc.indexOf(pair) != -1) {
                return true;
            }
        }
        // TODO govno
        return false;
    }

    static boolean twoBallsRule(String abc) {
        for (int i = 0; i < abc.length() - 2; i++) {
            if( abc.charAt(i) == abc.charAt(i+2)) {
                return true;
            }
        }
        return false;
    }

    static boolean isNice(String abc) {
        return validateVowelsRule(abc) && stutterRule(abc) && notABRule(abc);
    }

    static boolean isNice2(String abc) {
        return twoBallsRule(abc) && anyPairRule(abc);
    }


    static void executePart1(ArrayList<String> lineData) {
        int numberOfNiceStrings = 0;
        for (String line: lineData) {
            if (isNice(line)) {
                numberOfNiceStrings++;
            }
        }

        System.out.println("Part 1: " + numberOfNiceStrings);
    }

    static void executePart2(ArrayList<String> lineData) {

        int numberOfNiceStrings = 0;
        for (String line: lineData) {
            if (isNice2(line)) {
                numberOfNiceStrings++;
            }
        }

        System.out.println("Part 2: " + numberOfNiceStrings);
    }
}
