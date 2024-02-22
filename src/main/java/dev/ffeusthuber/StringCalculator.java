package dev.ffeusthuber;

public class StringCalculator {
    public int add(String calculationInput) {
        int result = 0;
        if(calculationInput.isEmpty())return result;

        String[] numbers = calculationInput.split("[,\\n]");
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            result += parsedNumber;
        }

        return result;
    }
}
