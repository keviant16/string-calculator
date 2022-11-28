package com.exalt.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorKata {
    static int add(String numbers) {

        //handle previous and // test
        String delimiter = numbers.startsWith("//") ? String.valueOf(numbers.charAt(2)) : ",";
        String numbersStr = numbers.startsWith("//") ? numbers.substring(4) : numbers;

        //stop condition
        if(numbers.equals("")) return 0;
        if(numbers.startsWith(delimiter) || numbers.contains(",\n") || numbers.contains("\n,")) return -1;

        //split numbers and parse number
        List<Integer> arrOfNumbers = Arrays.stream(numbersStr.split(delimiter + "|\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //check for negative number
        List<Integer> negativeList = arrOfNumbers.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (negativeList.size() > 0) throw new ArithmeticException("negatives not allowed: " + negativeList);

        Integer sum = arrOfNumbers.stream().reduce(Integer::sum).get();

        return sum;
    }
}
