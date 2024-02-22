package dev.ffeusthuber;

public class StringCalculator {
    public int add(String calculationString) {
        int result = 0;
        if(calculationString.isEmpty())return result;

        String[] numbers = calculationString.split(",");
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            result += parsedNumber;
        }

        return result;
    }
}
