package com.exalt.company;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculatorKata {
    static int add(String numbers) {
        if(numbers.equals("")) return 0;
        //split to array
        String[] arrOfNumbers = numbers.split(",");

        //forEach el
        //parse to int
        //reduce to sum
        Optional<Integer> i = Arrays.stream(arrOfNumbers)
                .map(num ->Integer.parseInt(num))
                .reduce((num1, num2) -> num1 +num2);

        return i.get();
    }
}
