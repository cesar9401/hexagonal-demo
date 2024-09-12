package com.hexagonal.demo.application.exception;

public class ForbiddenException extends Exception {

    public ForbiddenException(String message) {
        super(message);
    }
}
