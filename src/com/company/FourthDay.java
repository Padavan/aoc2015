package com.company;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;

public class FourthDay {
    public static void start() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("DAY 4");

        String test1 = "pqrstuv1048970"; //000006136ef...
        String test2 = "abcdef"; //000001dbbfa...

        String puzzleInput = "bgvyzdsv";
        Instant start = Instant.now();
        int part1 = getSmallestNumberForKey(puzzleInput, "00000");
        int part2 = getSmallestNumberForKey(puzzleInput, "000000");
        Instant end = Instant.now();
        System.out.println("Part 1:" + part1 + "Part 2:" + part2);
        // duration of operation
        System.out.println(Duration.between(start, end));
    }

    static int getSmallestNumberForKey(String input, String searchString) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        int i = 1;
        while(i < 32000000) {
            String joinedLine = input + Integer.toString(i);
//            System.out.println(joinedLine + " : " + getHash(joinedLine));
            if (checkHashForNull(getHash(joinedLine), searchString)) {
                return i;
            }

            i++;
        }

        return i;
    }

    static boolean checkHashForNull(String hash, String abc) {
        String hashSection = hash.substring(0, abc.length());
        return hashSection.equals(abc);
    }

    static String getHash(String line) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = line.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, thedigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }


}
