package com.example.meteorologicalsensorrestapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @Min(-100)
    @Max(100)
    @NotNull
    private double airTemplate;

    @NotNull
    private boolean raining;

    @NotNull
    private SensorDTO sensor;

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

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
