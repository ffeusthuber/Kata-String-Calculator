package dev.ffeusthuber;

public class StringCalculator {
    public int add(String calculationInput) {
        if(calculationInput.isEmpty())return 0;

        boolean hasCustomDelimiter = calculationInput.startsWith("//");
        String delimiter = hasCustomDelimiter ? getDelimiter(calculationInput) : ",";

        if(hasCustomDelimiter){
            calculationInput = removeFirstLine(calculationInput);
        }

        String[] numbers = calculationInput.split("[" + delimiter + "\\n]");

        int result = 0;

        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            result += parsedNumber;
        }

        return result;
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
