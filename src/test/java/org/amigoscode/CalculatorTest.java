package org.amigoscode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private final Calculator underTest = new Calculator();

    @Test
    public void canAddNumbers() {
        // 1) setup --> given

        var number1 = 3;
        var number2 = 3;

        // 2) invocation --> when

        var actual = underTest.add(number1, number2);
        var expected = 6;

        // 3) assertion --> then

        assertThat(actual).isEqualTo(6);
    }


}
