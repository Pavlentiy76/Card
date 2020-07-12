package com.pasha.exceptions;

public class NotEnoughMoneyException extends RuntimeException {


    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }

}
