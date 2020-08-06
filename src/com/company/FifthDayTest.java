package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FifthDayTest {

    @Test
    void validateVowelsRule() {
        assertFalse(FifthDay.validateVowelsRule("abs"));
        assertTrue(FifthDay.validateVowelsRule("aaa"));
        assertTrue(FifthDay.validateVowelsRule("aei"));
        assertTrue(FifthDay.validateVowelsRule("xazegov"));
        assertTrue(FifthDay.validateVowelsRule("aeiouaeiouaeiou"));
    }

    @Test
    void stutterRule() {
        assertFalse(FifthDay.stutterRule("abs"));
        assertTrue(FifthDay.stutterRule("abcdde"));
        assertTrue(FifthDay.stutterRule("aabbccdd"));
        assertTrue(FifthDay.stutterRule("xx"));
    }

    @Test
    void notABRule() {
        assertTrue(FifthDay.notABRule("acs"));
        assertFalse(FifthDay.notABRule("abcdpqxy"));
        assertFalse(FifthDay.notABRule("ab"));
        assertFalse(FifthDay.notABRule("cd"));
    }

    @Test
    void anyPairRule() {
        assertTrue(FifthDay.anyPairRule("xyxy"));
        assertTrue(FifthDay.anyPairRule("aabcdefgaa"));
        assertFalse(FifthDay.anyPairRule("aaa"));
    }

    @Test
    void twoBallsRule() {
        assertTrue(FifthDay.twoBallsRule("xyx"));
        assertTrue(FifthDay.twoBallsRule("abcdefeghi"));
        assertTrue(FifthDay.twoBallsRule("aaa"));
        assertFalse(FifthDay.twoBallsRule("abc"));
        assertFalse(FifthDay.twoBallsRule("abcdefghtabcdefg"));
    }

    @Test
    void isNice() {
        assertTrue(FifthDay.isNice("ugknbfddgicrmopn"));
        assertTrue(FifthDay.isNice("aaa"));
        assertFalse(FifthDay.isNice("jchzalrnumimnmhp"));
        assertFalse(FifthDay.isNice("haegwjzuvuyypxyu"));
        assertFalse(FifthDay.isNice("dvszwmarrgswjxmb"));
    }

    @Test
    void isNice2() {
        assertTrue(FifthDay.isNice2("qjhvhtzxzqqjkmpb"));
        assertTrue(FifthDay.isNice2("xxyxx"));
        assertFalse(FifthDay.isNice2("uurcxstgmygtbstg"));
        assertFalse(FifthDay.isNice2("ieodomkazucvgmuy"));
    }
}