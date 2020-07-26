package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourthDayTest {

    @Test
    void checkHashForNull() {
        assertFalse(FourthDay.checkHashForNull("abc", "000"));
    }
}