package com.example.meteorologicalsensorrestapi.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

// * Реализовать парсер метеорологический данных.
@Entity
@Table(name = "Measurement" )
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "air_template")
    @Size(min = -100, max = 100, message = "air template must be in the from -100 between 100 degrees")
    @NotNull
    private double airTemplate;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @Column(name = "measurement_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date measurementDateTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "name")
    @NotNull
    private Sensor sensor;

    public Measurement() {

    }
    public Measurement(int id, double airTemplate, boolean raining, Date measurementDateTime) {
        this.id = id;
        this.airTemplate = airTemplate;
        this.raining = raining;
        this.measurementDateTime = measurementDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getMeasurementDateTime() {
        return measurementDateTime;
    }

    public void setMeasurementDateTime(Date measurementDateTime) {
        this.measurementDateTime = measurementDateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
