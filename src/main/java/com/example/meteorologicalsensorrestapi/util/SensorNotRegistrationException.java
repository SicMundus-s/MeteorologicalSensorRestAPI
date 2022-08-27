package com.example.meteorologicalsensorrestapi.util;

public class SensorNotRegistrationException extends RuntimeException{
    public SensorNotRegistrationException(String msg) {
        super(msg);
    }
}
