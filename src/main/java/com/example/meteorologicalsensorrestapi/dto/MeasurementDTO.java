package com.example.meteorologicalsensorrestapi.dto;

import com.example.meteorologicalsensorrestapi.models.Sensor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeasurementDTO {

    @Min(-100)
    @Max(100)
    @NotNull
    private double airTemplate;

    @NotNull
    private boolean raining;

    @NotNull
    private Sensor sensor;

    public MeasurementDTO() {

    }

    public double getAirTemplate() {
        return airTemplate;
    }

    public void setAirTemplate(double airTemplate) {
        this.airTemplate = airTemplate;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
