package com.fabdelgado.ciuy;

import org.junit.jupiter.api.Test;

import com.fabdelgado.ciuy.Exceptions.EmptyCIException;
import com.fabdelgado.ciuy.Exceptions.NullCIException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

class ValidatorTest {
    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = new Validator();

    }

    @Test
    void validateCi() {
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
        String withDotsAndMiddleSlash = validator.cleanCi("4.502.218-6");
        String withSpecialCharacters = validator.cleanCi("4$502%2/18?! .-^()#@=6");
        String withLetters = validator.cleanCi("A4.502.AAA218-6B");

        assertEquals(expected, withDotsAndMiddleSlash);
        assertEquals(expected, withSpecialCharacters);
        assertEquals(expected, withLetters);

    }

    @Test
    void validationDigit() {
        assertEquals(8, validator.validationDigit("9.105.702-8"));
        assertEquals(4, validator.validationDigit("918.596-4"));
        assertEquals(6, validator.validationDigit("45022186"));
        assertEquals(5, validator.validationDigit("6032655"));
        assertEquals(1, validator.validationDigit("251821"));
    }

    @Test
    void randomCi() {
        for (int i = 0; i < 1000; i++) {
            String newCi = validator.randomCi();
            assertTrue(validator.validateCi(newCi));
        }
    }

    @Test
    void nullCI() {
        assertThrows(NullCIException.class, () -> validator.validateCi(null));
    }

    @Test
    void emptyCI() {
        Validator validator = new Validator();
        assertThrows(EmptyCIException.class, () -> validator.validateCi(new String()));
        assertThrows(EmptyCIException.class, () -> validator.validateCi(""));
    }

}