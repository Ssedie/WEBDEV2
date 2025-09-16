package com.zed.prelimss.exception;

import org.springframework.ui.Model;

public class ResourceNotFoundException {
    public String handleException(RuntimeException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/error";
    }
}
