package com.zed.prelimss.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message, int id) {
        super(message + ": " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message + ": not found");
    }
}
