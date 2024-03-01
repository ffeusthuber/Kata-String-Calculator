package dev.ffeusthuber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String calculationInput) {
        if(calculationInput.isEmpty())return 0;

        int[] numbers = extractNumbers(calculationInput);

        int result = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if(number < 0) {
                negativeNumbers.add(number);
            }
            result += number;
        }


        if(!negativeNumbers.isEmpty()) {
            String exceptionMessage = "negatives not allowed: " + negativeNumbers.stream()
                                                                                .map(Object::toString)
                                                                                .collect(Collectors.joining(","));
            throw new IllegalArgumentException(exceptionMessage);
        }

        return result;
    }

    private int[] extractNumbers(String calculationInput) {
        boolean hasCustomDelimiter = calculationInput.startsWith("//");
        String delimiter = hasCustomDelimiter ? getDelimiter(calculationInput) : ",";

        if(hasCustomDelimiter){
            calculationInput = removeFirstLine(calculationInput);
        }

        String[] numbers = calculationInput.split("[" + delimiter + "\\n]");

        return Arrays.stream(numbers)
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
    }

    private String removeFirstLine(String calculationInput) {
        calculationInput = calculationInput.substring(calculationInput.indexOf("\n")+1);
        return calculationInput;
    }

    private String getDelimiter(String calculationInput) {
        return calculationInput.split("\\n")[0]
                .substring(2);
    }
}
