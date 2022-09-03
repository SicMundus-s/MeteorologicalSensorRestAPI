package com.example.meteorologicalsensorrestapi.dto;

import com.example.meteorologicalsensorrestapi.models.Sensor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class MeasurementDTO {

    @Column(name = "air_template")
    @Size(min = -100, max = 100, message = "air template must be in the from -100 between 100 degrees")
    @NotNull
    private double airTemplate;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "name")
    @NotNull
    private Sensor owner;

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


    public Sensor getOwner() {
        return owner;
    }

    public void setOwner(Sensor owner) {
        this.owner = owner;
    }
}
