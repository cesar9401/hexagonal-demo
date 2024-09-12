package com.hexagonal.demo.application.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
