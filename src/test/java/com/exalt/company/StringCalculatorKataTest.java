package com.exalt.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorKataTest {

    @Test
    void test_step_one(){
        assertEquals(0, StringCalculatorKata.add(""));
        assertEquals(1, StringCalculatorKata.add("1"));
        assertEquals(3, StringCalculatorKata.add("1,2"));
    }

}
