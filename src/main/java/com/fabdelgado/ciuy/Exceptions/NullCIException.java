package com.fabdelgado.ciuy.Exceptions;

public class NullCIException extends NullPointerException {
    private static final String MESSAGE = "CI must not be Null.";

    public NullCIException() {
        super(MESSAGE);
    }
}
