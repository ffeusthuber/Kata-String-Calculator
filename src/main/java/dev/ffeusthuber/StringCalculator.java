package dev.ffeusthuber;

import java.util.Arrays;

public class StringCalculator {
    public int add(String calculationInput) {
        if(calculationInput.isEmpty())return 0;

        int[] numbers = extractNumbers(calculationInput);

        int result = 0;
        for (int number : numbers) {
            result += number;
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
