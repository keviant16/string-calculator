package com.exalt.company;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;
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

    @Test
    void test_add_numbers_with_unknown_amount_of_numbers(){
        //generate random length
        int length = (int) (Math.random() * (10 - 1 + 1) + 1);

        //generate string of number with random length
        String randoNumbers = generate(() -> "1,")
                .limit(length)
                .collect(Collectors.joining());

        assertEquals(length, StringCalculatorKata.add(randoNumbers));
    }

}
