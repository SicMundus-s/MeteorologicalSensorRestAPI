package com.example.meteorologicalsensorrestapi.controllers;


import com.example.meteorologicalsensorrestapi.util.ErrorResponse;
import com.example.meteorologicalsensorrestapi.util.SensorNotRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(SensorNotRegistrationException.class)
    private ResponseEntity<ErrorResponse> errorRegistrationSensor(SensorNotRegistrationException errorsMsg) {
        ErrorResponse response = new ErrorResponse(
                errorsMsg.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
