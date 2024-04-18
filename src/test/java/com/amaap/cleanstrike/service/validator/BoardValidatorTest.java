package com.amaap.cleanstrike.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardValidatorTest {

    @Test
    void shouldReturnFalseWhenInvalidParametersPassed() {
        //act
        boolean result = BoardValidator.validate(1, 3);
        boolean result1 = BoardValidator.validate(-1, 1);
        boolean result2 = BoardValidator.validate(9, 0);
        boolean result3 = BoardValidator.validate(0, 1);
        boolean result4 = BoardValidator.validate(-12, 1);
        boolean result5 = BoardValidator.validate(9, -3);
        assertTrue(result);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);
    }

    @Test
    void shouldReturnFalseWhenValidParametersPassed() {
        //act
        boolean result = BoardValidator.validate(9, 1);
        assertFalse(result);
    }

}