package com.fabdelgado.ciuy;

import java.util.Objects;
import java.util.Random;

import com.fabdelgado.ciuy.Exceptions.EmptyCIException;
import com.fabdelgado.ciuy.Exceptions.NullCIException;

public class Validator {

    /**
     * Returns if the identification number is valid
     *
     * @param ci String
     * @return boolean
     */
    public boolean validateCi(String ci) {
        validateInput(ci);
        String cleanCi = this.cleanCi(ci);
        char validationDigit = cleanCi.charAt(cleanCi.length() - 1);

        return Character.getNumericValue(validationDigit) == this.validationDigit(cleanCi);
    }

    /**
     * Validates that the CI is not empty or null.
     *
     * @param ci The CI as a String.
     * @throws NullCIException if the CI is null.
     * @throws EmptyCIException if the CI is empty.
     */
    public void validateInput(String ci) {
        if (Objects.isNull(ci)) {
            throw new NullCIException();
        }
        if (ci.isEmpty()) {
            throw new EmptyCIException();
        }
    }

    /**
     * Clean up removing all characters except numbers
     *
     * @param ci String
     * @return String
     */
    public String cleanCi(String ci) {
        return ci.replaceAll("[^0-9]", "");
    }

    /**
     * Check validation digit from a number of ci
     *
     * @param ci String
     * @return Integer
     */
    protected Integer validationDigit(String ci) {
        String cleanCi = this.cleanCi(ci);
        int a = 0;
        String baseNumber = "2987634";
        String addZeros = String.format("%8s", cleanCi).replace(" ", "0");

        for (int i = 0; i < baseNumber.length(); i++) {
            int baseDigit = Character.getNumericValue(baseNumber.charAt(i));
            int ciWithZeros = Character.getNumericValue(addZeros.charAt(i));
            a += (baseDigit * ciWithZeros) % 10;
        }
        return a % 10 == 0 ? 0 : 10 - a % 10;
    }

    /**
     * Generate a valid random identification number
     *
     * @return String
     */
    public String randomCi() {
        int randomNumber = 10000000 + new Random().nextInt(90000000);
        return String.valueOf(randomNumber).substring(0, 7) + this.validationDigit(String.valueOf(randomNumber));
    }

    /**
     * Returns if the identification number is valid
     *
     * @param ci Long version of the identity card
     * @return boolean
     */
    public boolean validateCi(Long ci) {
        if (ci == null) {
            throw new NullCIException();
        }
        return validateCi(String.valueOf(ci));
    }

    /**
     * Returns if the identification number is valid
     *
     * @param ci Integer version of the identity card
     * @return boolean
     */
    public boolean validateCi(Integer ci) {
        return validateCi(String.valueOf(ci));
    }
}
