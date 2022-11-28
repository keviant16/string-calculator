package com.exalt.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorKataTest {

    @Test
    void test_add_number(){
        assertEquals(1, StringCalculatorKata.add("1"));
    }

    @Test
    void test_add_with_empty_string(){
        assertEquals(0, StringCalculatorKata.add(""));
    }

    @Test
    void test_add_numbers_with_comma(){
        assertEquals(3, StringCalculatorKata.add("1,2"));
    }

    @Test
    void test_add_numbers_start_with_comma(){
        assertEquals(-1, StringCalculatorKata.add(",1,2"));
    }

    @Test
    void test_add_numbers_end_with_comma(){
        assertEquals(3, StringCalculatorKata.add("1,2,"));
    }

    @Test
    void test_add_numbers_with_unknown_amount_of_numbers(){
        int length = (int) (Math.random() * (10 - 1 + 1) + 1);

        String randoNumbers = generate(() -> "1,")
                .limit(length)
                .collect(Collectors.joining());

        assertEquals(length, StringCalculatorKata.add(randoNumbers));
    }

    @Test
    void test_add_numbers_with_new_lines_between_numbers(){
        assertEquals(6, StringCalculatorKata.add("1\n2,3"));
    }

    @Test
    void test_add_handle_new_lines_between_numbers_is_not_ok(){
        assertEquals(-1, StringCalculatorKata.add("1,\n"));
    }

    @Test
    void test_add_handle_new_lines_between_numbers_is_not_ok_reverse(){
        assertEquals(-1, StringCalculatorKata.add("1\n,"));
    }

    @Test
    void test_add_with_different_delimiters(){
        assertEquals(3, StringCalculatorKata.add("//;\n1;2"));
    }

    @Test
    void test_add_with_negative_numbers(){
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            StringCalculatorKata.add("//:\n-1:2:9:6:-7");
        });

        Assertions.assertEquals("negatives not allowed: [-1, -7]", thrown.getMessage());
    }
}
