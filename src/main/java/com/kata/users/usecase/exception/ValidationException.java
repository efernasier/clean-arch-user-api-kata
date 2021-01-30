package com.kata.users.usecase.exception;

public class ValidationException extends Exception {
    public ValidationException(final String message){
        super(message);
    }
}
