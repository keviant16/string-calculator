package com.exalt.company;

import java.util.Arrays;

public class StringCalculatorKata {
    static int add(String numbers) {
        if(numbers.equals("")) return 0;

        //split numbers to array
        String[] arrOfNumbers = numbers.split(",");

        //parse to int and reduce
        Integer i = Arrays.stream(arrOfNumbers)
                .map(Integer::parseInt)
                .reduce((num1, num2) -> num1 + num2).get();

        return i;
    }
}
