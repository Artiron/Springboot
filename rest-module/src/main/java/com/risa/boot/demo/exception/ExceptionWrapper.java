package com.risa.boot.demo.exception;

public class ExceptionWrapper {
    private String message;

    public ExceptionWrapper(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
