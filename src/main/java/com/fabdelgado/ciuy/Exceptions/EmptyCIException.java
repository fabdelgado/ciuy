package com.fabdelgado.ciuy.Exceptions;

public class EmptyCIException extends NullPointerException {
    private static final String MESSAGE = "CI must not be empty.";

    public EmptyCIException() {
        super(MESSAGE);
    }
}
