package com.example.meteorologicalsensorrestapi.dto;


import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {

    @NotEmpty(message = "name must not be empty")
    @Size(min = 3, max = 30, message = "name must be in the from 3 between 30 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
