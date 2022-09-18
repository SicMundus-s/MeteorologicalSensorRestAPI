package com.example.meteorologicalsensorrestapi.util;

public class SensorNotFoundException extends RuntimeException{
    public SensorNotFoundException(String msg) {
        super(msg);
    }
}
