package dev.ffeusthuber;

public class StringCalculator {

    private final InputProcessor inputProcessor;

    public StringCalculator(){
        inputProcessor = new InputProcessor();
    }

    public int add(String calculationInput) {
        int result = 0;
        if(calculationInput.isEmpty())return result;

        int[] numbers = inputProcessor.extractNumbers(calculationInput);
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
