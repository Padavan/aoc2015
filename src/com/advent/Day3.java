package com.advent;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day3 {
    public static void start() {
        System.out.println("-- Day 3 --");

        String filePath = "\\input\\day3.txt";
        List<String> lineData = FileInputReader.readInput(filePath);
        char[] directionsList = lineData.get(0).toCharArray();

        Map<String, Integer> housesList = getVisitedHousesList(directionsList);
        System.out.println("Part 1: " + housesList.size());

        Map<String, Integer> housesListByTwoSantas = getVisitedHousesListByTwoSantas(directionsList);
        System.out.println("Part 2: " + housesListByTwoSantas.size());
    }

    public static Map<String, Integer> getVisitedHousesList(char[] directions) {
        Map<String, Integer> visitedHomes = new HashMap<>();
        visitedHomes.put("x0y0", 1);

        int x = 0, y = 0;
        for (char direction : directions) {
            switch (direction) {
                case '^' -> y = y + 1;
                case 'v' -> y = y - 1;
                case '>' -> x = x + 1;
                case '<' -> x = x - 1;
                default -> {
                }
            }
            String homeCoord = 'x' + Integer.toString(x) + 'y' + Integer.toString(y);
            int visitCounter = 0;
            if (visitedHomes.containsKey(homeCoord)) {
                visitCounter = visitedHomes.get(homeCoord);
            }
            visitCounter += 1;
            visitedHomes.put(homeCoord, visitCounter);
//            visitedHomes.put()
        }

        return visitedHomes;
    }

    public static Map<String, Integer> getVisitedHousesListByTwoSantas(char[] directions) {
        Map<String, Integer> visitedHomes = new HashMap<>();

        visitedHomes.put("x0y0", 2);

        int x = 0, y = 0;
        int bufferX = 0, bufferY = 0;

        int i;
        for (i = 0; i < directions.length; i++) {
            switch (directions[i]) {
                case '^' -> y = y + 1;
                case 'v' -> y = y - 1;
                case '>' -> x = x + 1;
                case '<' -> x = x - 1;
                default -> {
                }
            }

            String homeCoord = 'x' + Integer.toString(x) + 'y' + Integer.toString(y);
            int visitCounter = 0;
            if (visitedHomes.containsKey(homeCoord)) {
                visitCounter = visitedHomes.get(homeCoord);
            }
            visitCounter += 1;
            visitedHomes.put(homeCoord, visitCounter);

            int tempX = x, tempY = y;
            x = bufferX;
            y = bufferY;
            bufferX = tempX;
            bufferY = tempY;
        }

        return visitedHomes;
    }
}
