package com.example.meteorologicalsensorrestapi.controllers;


import com.example.meteorologicalsensorrestapi.util.ErrorResponse;
import com.example.meteorologicalsensorrestapi.util.SensorNotRegistrationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ExceptionApiHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorNotRegistrationException.class)
    private ResponseEntity<ErrorResponse> errorRegistrationSensor(SensorNotRegistrationException errorsMsg) {
        List<String> errors = Collections.singletonList(errorsMsg.getMessage());
        ErrorResponse response = new ErrorResponse(
                errors,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField() + ": " + x.getDefaultMessage()).toList();


        ErrorResponse response = new ErrorResponse(
                errors,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
