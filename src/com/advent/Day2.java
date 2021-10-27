package com.advent;

import java.util.*;
import java.util.stream.Collectors;

public class Day2 {
    public static void start() {
        System.out.println("-- Day 2 --");

        String filePath = "\\input\\day2.txt";
        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        calcWrappingPaper(lineData);
        calcRibbonLength(lineData);
    }

    public static void calcWrappingPaper(ArrayList<String> lineData) {
        int dimensionLine = 0;
        int sumsQuare = 0;
        for(String dimStr: lineData) {
            String[] stringNumbers = dimStr.split("x");
            List<Integer> numberArrayList = Arrays.stream(stringNumbers).map(Integer::valueOf).collect(Collectors.toList());

            List<Integer> areaList = new ArrayList<>();
            areaList.add(numberArrayList.get(0) * numberArrayList.get(1));
            areaList.add(numberArrayList.get(1) * numberArrayList.get(2));
            areaList.add(numberArrayList.get(0) * numberArrayList.get(2));
            sumsQuare += areaList.stream().mapToInt(number -> 2 * number).sum();
            sumsQuare += Collections.min(areaList);
            dimensionLine += 1;
        }
        System.out.println("Part 1: " + sumsQuare);
    }

    public static void calcRibbonLength(ArrayList<String> lineData) {
        int line = 0;
        int ribbonLength = 0;
        for(String dimStr: lineData) {
            String[] stringNumbers = dimStr.split("x");
            List<Integer> sortedFaces = Arrays.stream(stringNumbers).map(Integer::valueOf).sorted().collect(Collectors.toList());

            ribbonLength += (sortedFaces.get(0)+sortedFaces.get(1)) * 2;
            ribbonLength += sortedFaces.stream().reduce(1, (acc, cur) -> acc * cur);
            line += 1;
        }
        System.out.println("Part 2: " + ribbonLength);
    }
}
