package com.company;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ThirdDay {
    public static void start() {
        String filePath = "c:\\data\\directions.txt";

        List<String> lineData = FileInputReader.readInput(filePath);
        char[] directionsList = lineData.get(0).toCharArray();
        System.out.println(directionsList);
//        Map<String, Integer> list = getVisitedHousesList(directionsList);
        Map<String, Integer> list = getVisitedHousesListByTwoSantas(directionsList);
//        long lenghtList = list.entrySet().stream()
//                .filter(house -> house.getValue() > 1).count();
        System.out.println(list.size());
    }

    public static Map<String, Integer> getVisitedHousesList(char[] directions) {
        Map<String, Integer> visitedHomes = new HashMap<>();
        visitedHomes.put("x0y0", 1);

        int x = 0, y = 0;
        for (char direction : directions) {
            switch (direction) {
                case '^':
                    y = y + 1;
                    break;
                case 'v':
                    y = y - 1;
                    break;
                case '>':
                    x = x + 1;
                    break;
                case '<':
                    x = x - 1;
                    break;
                default:
                    break;
            }
            String homeCoord = 'x' + Integer.toString(x) + 'y' + Integer.toString(y);
            int visitCounter = 0;
            if (visitedHomes.containsKey(homeCoord)) {
                visitCounter = visitedHomes.get(homeCoord);
            }
            visitCounter += 1;
            System.out.println("Coordinates:" + homeCoord + "Count:" + visitCounter);
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
                case '^':
                    y = y + 1;
                    break;
                case 'v':
                    y = y - 1;
                    break;
                case '>':
                    x = x + 1;
                    break;
                case '<':
                    x = x - 1;
                    break;
                default:
                    break;
            }


            String homeCoord = 'x' + Integer.toString(x) + 'y' + Integer.toString(y);
            int visitCounter = 0;
            if (visitedHomes.containsKey(homeCoord)) {
                visitCounter = visitedHomes.get(homeCoord);
            }
            visitCounter += 1;
            System.out.println("Coordinates:" + homeCoord + " Count:" + visitCounter);
            visitedHomes.put(homeCoord, visitCounter);
//            visitedHomes.put()
            // coordinates swap
            int tempX = x, tempY = y;
            x = bufferX;
            y = bufferY;
            bufferX = tempX;
            bufferY = tempY;


        }

        return visitedHomes;
    }

//    public static void swap(String [] a){
//        String temp;
//        temp = a[0];
//        a[0] = a[1];
//        a[1] = temp;
//    }
}
