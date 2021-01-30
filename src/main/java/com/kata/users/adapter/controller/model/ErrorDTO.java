package com.kata.users.adapter.controller.model;

public class ErrorDTO {
    String error;
    String message;

    public ErrorDTO(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
