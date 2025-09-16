package com.zed.prelimss.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {

    @ExceptionHandler(value = RuntimeException.class)
    public String handleException(RuntimeException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/error";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error/error";
    }
}
