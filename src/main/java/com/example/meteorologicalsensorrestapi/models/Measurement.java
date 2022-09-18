package com.example.meteorologicalsensorrestapi.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

// * Реализовать парсер метеорологический данных.
@Entity
@Table(name = "Measurement" )
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "air_temperature")
    //@Size(min = -100, max = 100, message = "air template must be in the from -100 between 100 degrees")
    @Min(-100)
    @Max(100)
    @NotNull
    private double airTemperature;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @Column(name = "measurement_date_time")
    @NotNull
    private LocalDateTime measurementDateTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "name")
    @NotNull
    private Sensor sensor;

    public Measurement() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public LocalDateTime getMeasurementDateTime() {
        return measurementDateTime;
    }

    public void setMeasurementDateTime(LocalDateTime measurementDateTime) {
        this.measurementDateTime = measurementDateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
