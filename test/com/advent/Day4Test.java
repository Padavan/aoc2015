package com.advent;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    void checkHashForNull() {
        assertFalse(Day4.checkHashForNull("abc", "000"));
    }

    @Test
    void testGetSmallestNumberForKey() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        assertEquals(Day4.getSmallestNumberForKey("abcdef", "00000"), 609043);
        assertEquals(Day4.getSmallestNumberForKey("pqrstuv", "00000"), 1048970);
    }

}