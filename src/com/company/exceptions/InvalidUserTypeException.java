package com.company.exceptions;

public class InvalidUserTypeException extends Exception {
    public InvalidUserTypeException(String message) {
        super(message);
    }

    public InvalidUserTypeException() {
        super("");
    }
}
