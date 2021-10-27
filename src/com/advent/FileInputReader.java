package com.advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class FileInputReader {
    public static ArrayList<String> readInput(String path) {
        ArrayList<String> lineData = new ArrayList<>();
        String projectFolder = new File("").getAbsolutePath();
        String inputPath = projectFolder + path;

        try (BufferedReader reader = new BufferedReader(new FileReader(projectFolder + path))) {
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                lineData.add(line);
                // read next line
                line = reader.readLine();
            }
        } catch (Exception ex) {
            System.out.println("readLine() failed.");
        }

        return lineData;
    }
}