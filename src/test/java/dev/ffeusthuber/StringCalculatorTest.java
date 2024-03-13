package dev.ffeusthuber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void addingEmptyStringReturns0() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void addingSingleNumberReturnsCorrectInteger() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void addingMultipleNumbersReturnsSum() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1,2,5,2");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void newLinesInsteadOfCommasInTheInputStringReturnsCorrectResult() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1,2\n5,2");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void inputWithCustomDelimiterGetsCalculatedCorrectly() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("//;\n1;2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void inputWithNegativeNumbersThrowsException() {
        StringCalculator stringCalculator = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,-3,-4"));
        assertThat(exception.getMessage()).isEqualTo("negatives not allowed: -3,-4");
    }

    @Test
    void numbersGreaterThanThousandGetIgnoredInInput() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1,2,1001,1000");

        assertThat(result).isEqualTo(1003);
    }

    @Test
    void inputWithDelimiterWithALengthGreaterThanOneGetsCalculatedCorrectly() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("//[***]\n1***2***3");

        assertThat(result).isEqualTo(6);
    }

}
