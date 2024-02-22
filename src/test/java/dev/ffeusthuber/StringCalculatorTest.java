package dev.ffeusthuber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void addingEmptyStringShouldReturn0() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("");

        assertThat(result).isEqualTo(0);
    }
}
