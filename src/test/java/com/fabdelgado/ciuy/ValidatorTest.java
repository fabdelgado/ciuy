package com.fabdelgado.ciuy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @Test
    void validateCi() {
        Validator validator = new Validator();

        assertTrue(validator.validateCi("1.095.871-8"));
        assertTrue(validator.validateCi("6032655"));
        assertFalse(validator.validateCi("6032652"));
        assertFalse(validator.validateCi("17367033"));
        assertTrue(validator.validateCi(10958718));
        assertTrue(validator.validateCi(6032655));
        assertFalse(validator.validateCi(6032652));
        assertFalse(validator.validateCi(17367033));
        assertTrue(validator.validateCi(10958718L));
        assertTrue(validator.validateCi(6032655L));
        assertFalse(validator.validateCi(6032652L));
        assertFalse(validator.validateCi(17367033L));
    }

    @Test
    void cleanCi() {
        String expected = "45022186";
        Validator validator = new Validator();
        String withDotsAndMiddleSlash = validator.cleanCi("4.502.218-6");
        String withSpecialCharacters = validator.cleanCi("4$502%2/18?! .-^()#@=6");
        String withLetters = validator.cleanCi("A4.502.AAA218-6B");

        assertEquals(expected, withDotsAndMiddleSlash);
        assertEquals(expected, withSpecialCharacters);
        assertEquals(expected, withLetters);

    }

    @Test
    void validationDigit() {
        Validator validator = new Validator();

        assertEquals(8, validator.validationDigit("9.105.702-8"));
        assertEquals(4, validator.validationDigit("918.596-4"));
        assertEquals(6, validator.validationDigit("45022186"));
        assertEquals(5, validator.validationDigit("6032655"));
        assertEquals(1, validator.validationDigit("251821"));
    }

    @Test
    void randomCi() {
        Validator validator = new Validator();

        for (int i = 0; i < 1000; i++) {
            String newCi = validator.randomCi();
            assertTrue(validator.validateCi(newCi));
        }
    }
}