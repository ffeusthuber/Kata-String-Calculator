package dev.ffeusthuber;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputProcessor {

    public int[] extractNumbers(String calculationInput) {
        int[] parsedNumbers = parse(calculationInput);
        validate(parsedNumbers);
        return sanitize(parsedNumbers);
    }


    private int[] parse(String calculationInput) {
        String[] numbers = tokenizeInput(calculationInput);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String[] tokenizeInput(String calculationInput) {
        boolean hasCustomDelimiter = calculationInput.startsWith("//");
        String delimiter = hasCustomDelimiter ? extractDelimiter(calculationInput) : ",";
        if(hasCustomDelimiter) calculationInput = removeFirstLine(calculationInput);

        return calculationInput.split(  Pattern.quote(delimiter) + "|\\n");
    }
    private void validate(int[] numbers) {
        checkForNegatives(numbers);
    }

    private int[] sanitize(int[] numbers) {
        return dropNumbersGreaterThan1000(numbers);
    }

    private void checkForNegatives(int[] numbers) {
        int[] negativeNumbers = Arrays.stream(numbers).filter(num -> num <0).toArray();

        if(negativeNumbers.length != 0) {
            String exceptionMessage = "negatives not allowed: " + Arrays.stream(negativeNumbers)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private int[] dropNumbersGreaterThan1000(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> num <= 1000)
                .toArray();
    }


    private String removeFirstLine(String calculationInput) {
        calculationInput = calculationInput.substring(calculationInput.indexOf("\n")+1);
        return calculationInput;
    }

    private String extractDelimiter(String calculationInput) {
        String delimiter =  calculationInput.split("\\n")[0]
                .substring(2);

        if(delimiter.startsWith("[")){
            int delimiterStart = 1;
            int delimiterEnd = delimiter.indexOf("]");
            delimiter = delimiter.substring(delimiterStart,delimiterEnd);
        }

        System.out.println(delimiter);
        return delimiter;
    }
}
