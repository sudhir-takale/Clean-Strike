package com.amaap.cleanstrike.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardValidatorTest {

    @Test
    void shouldBeAbleToCreateInstance() {
        // arrange & act
        BoardValidator boardValidator = new BoardValidator();

        // assert
        assertNotNull(boardValidator);
    }

    @Test
    void shouldReturnFalseWhenInvalidParametersPassed() {
        //act
        boolean result = BoardValidator.validate(1, 3);
        boolean result1 = BoardValidator.validate(-1, 1);
        boolean result2 = BoardValidator.validate(9, 0);
        boolean result3 = BoardValidator.validate(0, 1);
        boolean result4 = BoardValidator.validate(-12, 1);
        boolean result5 = BoardValidator.validate(9, -3);

        // assert
        assertFalse(result);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
    }

    @Test
    void shouldReturnTrueWhenValidParametersPassed() {
        // act
        boolean result = BoardValidator.validate(9, 1);

        // assert
        assertTrue(result);
    }

}