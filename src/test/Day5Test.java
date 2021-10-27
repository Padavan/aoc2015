package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void validateVowelsRule() {
        assertFalse(Day5.validateVowelsRule("abs"));
        assertTrue(Day5.validateVowelsRule("aaa"));
        assertTrue(Day5.validateVowelsRule("aei"));
        assertTrue(Day5.validateVowelsRule("xazegov"));
        assertTrue(Day5.validateVowelsRule("aeiouaeiouaeiou"));
    }

    @Test
    void stutterRule() {
        assertFalse(Day5.stutterRule("abs"));
        assertTrue(Day5.stutterRule("abcdde"));
        assertTrue(Day5.stutterRule("aabbccdd"));
        assertTrue(Day5.stutterRule("xx"));
    }

    @Test
    void notABRule() {
        assertTrue(Day5.notABRule("acs"));
        assertFalse(Day5.notABRule("abcdpqxy"));
        assertFalse(Day5.notABRule("ab"));
        assertFalse(Day5.notABRule("cd"));
    }

    @Test
    void anyPairRule() {
        assertTrue(Day5.anyPairRule("xyxy"));
        assertTrue(Day5.anyPairRule("aabcdefgaa"));
        assertFalse(Day5.anyPairRule("aaa"));
    }

    @Test
    void twoBallsRule() {
        assertTrue(Day5.twoBallsRule("xyx"));
        assertTrue(Day5.twoBallsRule("abcdefeghi"));
        assertTrue(Day5.twoBallsRule("aaa"));
        assertFalse(Day5.twoBallsRule("abc"));
        assertFalse(Day5.twoBallsRule("abcdefghtabcdefg"));
    }

    @Test
    void isNice() {
        assertTrue(Day5.isNice("ugknbfddgicrmopn"));
        assertTrue(Day5.isNice("aaa"));
        assertFalse(Day5.isNice("jchzalrnumimnmhp"));
        assertFalse(Day5.isNice("haegwjzuvuyypxyu"));
        assertFalse(Day5.isNice("dvszwmarrgswjxmb"));
    }

    @Test
    void isNice2() {
        assertTrue(Day5.isNice2("qjhvhtzxzqqjkmpb"));
        assertTrue(Day5.isNice2("xxyxx"));
        assertFalse(Day5.isNice2("uurcxstgmygtbstg"));
        assertFalse(Day5.isNice2("ieodomkazucvgmuy"));
    }
}