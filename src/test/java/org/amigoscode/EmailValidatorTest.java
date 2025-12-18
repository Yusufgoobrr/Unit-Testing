package org.amigoscode;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "hello@gmail.com, true",
            "hellogmail.com, false",
            " , false"
    })
    @DisplayName("EmailValidator")
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Fast")
    void canValidateEmail(String email, boolean expected) {

        // when
        var result = emailValidator.test(email);
        // then
        assertThat(result).isEqualTo(expected);
    }
}