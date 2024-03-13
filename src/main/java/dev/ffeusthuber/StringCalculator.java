package dev.ffeusthuber;

import java.util.Arrays;

public class StringCalculator {

    private final InputProcessor inputProcessor;

    public StringCalculator(){
        inputProcessor = new InputProcessor();
    }

    public int add(String calculationInput) {
        if(calculationInput.isEmpty())return 0;

        int[] numbers = inputProcessor.extractNumbers(calculationInput);

        return Arrays.stream(numbers).sum();
    }
}
