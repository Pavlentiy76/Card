package com.pasha.exceptions;

public class NotPositiveValueException extends RuntimeException {

    public NotPositiveValueException() {
    }

    public NotPositiveValueException(String message) {
        super(message);
    }

}
