package com.exalt.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorKataTest {

    @Test
    void test_add_empty_string(){
        assertEquals(0, StringCalculatorKata.add(""));
    }

    @Test
    void test_add_number(){
        assertEquals(1, StringCalculatorKata.add("1"));
    }

    @Test
    void test_add_numbers_with_comma(){
        assertEquals(3, StringCalculatorKata.add("1,2"));
    }
}
