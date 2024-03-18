package dev.ffeusthuber;

public class StringCalculator {

    private final InputProcessor inputProcessor;

    public StringCalculator(){
        inputProcessor = new InputProcessor();
    }

    public int add(String calculationInput) {
        if(calculationInput.isEmpty())return 0;
        return inputProcessor.extractNumbers(calculationInput).sum();
    }
}
