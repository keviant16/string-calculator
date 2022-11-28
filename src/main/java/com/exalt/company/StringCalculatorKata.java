package com.exalt.company;

import java.util.Arrays;

public class StringCalculatorKata {
    static int add(String numbers) {

        String delimiter = numbers.startsWith("//") ? String.valueOf(numbers.charAt(2)) : ",";
        String numbersStr =  numbers.startsWith("//") ? numbers.substring(4) : numbers;

        if(numbers.equals("")) return 0;
        if(numbers.startsWith(delimiter) || numbers.contains(",\n") || numbers.contains("\n,")) return -1;

        //split numbers to array
        String[] arrOfNumbers = numbersStr.split(delimiter + "|\\s");

        //parse to int and reduce
        Integer i = Arrays.stream(arrOfNumbers)
                .map(Integer::parseInt)
                .reduce((num1, num2) -> num1 + num2).get();

        return i;
    }
}
