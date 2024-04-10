package com.amaap.cleanstrike.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardValidatorTest {

    @Test
    void shouldReturnFalseWhenInvalidParametersPassed() {
        //act
        boolean result = BoardValidator.validate(1, 3);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenValidParametersPassed() {
        //act
        boolean result = BoardValidator.validate(9, 1);
        assertFalse(result);
    }

}