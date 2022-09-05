package com.example.meteorologicalsensorrestapi.service;


import com.example.meteorologicalsensorrestapi.models.Measurement;
import com.example.meteorologicalsensorrestapi.repositories.MeasurementRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepositories measurementRepositories;

    public MeasurementService(MeasurementRepositories measurementRepositories) {
        this.measurementRepositories = measurementRepositories;
    }

    @Transactional
    public void save(Measurement measurement) {
        measurementRepositories.save(measurement);
    }
}
