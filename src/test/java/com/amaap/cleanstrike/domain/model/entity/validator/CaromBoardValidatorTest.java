package com.amaap.cleanstrike.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CaromCaromBoardValidatorTest {


    @Test
    void shouldBeAbleToCreateInstance() {
        // arrange & act
        CaromBoardValidator boardValidator = new CaromBoardValidator();

        // assert
        assertNotNull(boardValidator);
    }

    @Test
    void shouldReturnFalseWhenInvalidParametersPassed() {
        //act
        boolean result = CaromBoardValidator.validate(1, 3);
        boolean result1 = CaromBoardValidator.validate(-1, 1);
        boolean result2 = CaromBoardValidator.validate(9, 0);
        boolean result3 = CaromBoardValidator.validate(0, 1);
        boolean result4 = CaromBoardValidator.validate(-12, 1);
        boolean result5 = CaromBoardValidator.validate(9, -3);

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
        boolean result = CaromBoardValidator.validate(9, 1);

        // assert
        assertTrue(result);
    }

}