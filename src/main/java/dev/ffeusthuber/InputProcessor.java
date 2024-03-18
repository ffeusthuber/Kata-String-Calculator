package dev.ffeusthuber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputProcessor {

    public IntStream extractNumbers(String calculationInput) {
        int[] parsedNumbers = parse(calculationInput);
        validate(parsedNumbers);
        return Arrays.stream(sanitize(parsedNumbers));
    }

    private int[] parse(String calculationInput) {
        String[] numbers = tokenizeInput(calculationInput);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String[] tokenizeInput(String calculationInput) {
        List<String> delimiters = getDelimiters(calculationInput);
        if(calculationInput.startsWith("//")) calculationInput = removeFirstLine(calculationInput);

        delimiters.replaceAll(Pattern::quote);

        return  calculationInput.split(
                String.join("|", delimiters));
    }

    private List<String> getDelimiters(String calculationInput) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add("\n");

        boolean hasCustomDelimiter = calculationInput.startsWith("//");
        if(hasCustomDelimiter){
            delimiters.addAll(extractDelimiters(calculationInput));
        } else{
            delimiters.add(",");
        }

        return delimiters;
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

    private List <String> extractDelimiters(String calculationInput) {
        String delimiterPart =  calculationInput.split("\\n")[0]
                .substring(2);

        List<String> delimiters = new ArrayList<>();

        if(delimiterPart.startsWith("[")){
            while (!delimiterPart.isEmpty()){
                int delimiterStart = 1;
                int delimiterEnd = delimiterPart.indexOf("]");
                String delimiter = delimiterPart.substring(delimiterStart,delimiterEnd);
                delimiters.add(delimiter);
                delimiterPart = delimiterPart.substring(delimiterEnd + 1);
            }
        }else {
            delimiters.add(delimiterPart);
        }

        return delimiters;
    }
}
