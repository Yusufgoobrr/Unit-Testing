package org.amigoscode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void canAddNumbers(){
Calculator calculator = new Calculator();
var result = calculator.add(3,3);
assertEquals(6,result);
    }
}
