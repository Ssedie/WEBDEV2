package com.zed.prelimss.exception;

import org.springframework.ui.Model;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message, int id) {
        super(message + ": " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message + ": not found");
    }
}
