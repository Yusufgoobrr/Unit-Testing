package org.amigoscode;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new Calculator();
    }

    @AfterEach
    void tearDown() {

    }

    // does execute after each class
    @AfterAll
    static void afterAll() {

    }

    // does exectute before each class
    @BeforeAll
    static void beforeAll() {

    }

    @Test
    public void canAddNumbers() {
        System.out.println("canAddNumbers");
        // 1) setup --> given

        var number1 = 3;
        var number2 = 3;

        // 2) invocation --> when

        var actual = underTest.add(number1, number2);
        var expected = 6;

        // 3) assertion --> then

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void name() {
        System.out.println("name");
    }
}
