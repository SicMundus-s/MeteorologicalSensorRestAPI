package com.example.meteorologicalsensorrestapi.util;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private List<String> errors;

    private LocalDateTime timestamp;

    public ErrorResponse(List<String> errors, LocalDateTime timestamp) {
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
