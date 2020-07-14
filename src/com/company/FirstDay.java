package com.company;

import java.util.Scanner;

public class FirstDay {

    public static void start(String[] args) {

        String input = InputReader.readInput();

        char[] charArray = input.toCharArray();

        int currentFloor = 0;

        int i;
        for (i=0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '(':
                    currentFloor = currentFloor + 1;
                    break;
                case ')':
                    currentFloor = currentFloor - 1;
                    break;
                default:
                    break;
            }

            if (currentFloor == -1) {
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(i);
        System.out.println(currentFloor);
    }
}

class InputReader {
    public static String readInput() {
        System.out.println("Enter Advent String");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }
}
