package com.fabdelgado.ciuy;

import java.util.Random;

public class Validator {

    /**
     * Returns if the identification number is valid
     *
     * @param ci
     * @return boolean
     */
    public boolean validateCi(String ci) {
        String cleanCi = this.cleanCi(ci);
        char validationDigit = cleanCi.charAt(cleanCi.length() - 1);

        return Character.getNumericValue(validationDigit) == this.validationDigit(cleanCi);
    }

    /**
     * Clean up removing all characters except numbers
     *
     * @param ci
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
        int a = 0;
        String baseNumber = "2987634";
        String addZeros = String.format("%8s", ci).replace(" ", "0");

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
        String ci = String.valueOf(randomNumber).substring(0, 7) + this.validationDigit(String.valueOf(randomNumber));
        return ci;
    }
}
