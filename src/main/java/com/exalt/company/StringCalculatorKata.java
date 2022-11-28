package com.exalt.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class StringCalculatorKata {
    static int add(String numbers) {

        String delimiter = numbers.startsWith("//") ? String.valueOf(numbers.charAt(2)) : ",";
        String numbersStr = numbers.startsWith("//") ? numbers.substring(4) : numbers;

        if(numbers.equals("")) return 0;
        if(numbers.startsWith(delimiter) || numbers.contains(",\n") || numbers.contains("\n,")) return -1;

        List<String> numbersList = Arrays.asList(numbersStr.split(delimiter + "|\\s"));
        List<Integer> negativeNumbers = new ArrayList<>();

        Integer sum = numbersList.stream()
                .map(n -> {
                    Integer integer = parseInt(n);
                    if(integer < 0) negativeNumbers.add(integer);
                    return integer;
                })
                .reduce(Integer::sum).get();

        if (negativeNumbers.size() > 0) throw new ArithmeticException("negatives not allowed: " + negativeNumbers);
        return sum;
    }
}
