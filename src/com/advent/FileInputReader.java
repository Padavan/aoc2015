package com.advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileInputReader {
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

    public static String readWholeInput(String path) {
        String projectFolder = new File("").getAbsolutePath();
        String inputPath = projectFolder + path;
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(projectFolder + path))) {
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            // delete the last new line separator
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

        } catch (Exception ex) {
            System.out.println("readLine() failed.");
        }

        String content = stringBuilder.toString();
        return content;
    }
}