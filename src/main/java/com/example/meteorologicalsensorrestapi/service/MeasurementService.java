package com.example.meteorologicalsensorrestapi.service;


import com.example.meteorologicalsensorrestapi.models.Measurement;
import com.example.meteorologicalsensorrestapi.repositories.MeasurementRepositories;
import com.example.meteorologicalsensorrestapi.util.SensorNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepositories measurementRepositories;
    private final SensorsService sensorService;

    public MeasurementService(MeasurementRepositories measurementRepositories, SensorsService sensorsService) {
        this.measurementRepositories = measurementRepositories;
        this.sensorService = sensorsService;
    }

    @Transactional
    public void save(Measurement measurement) {

        if(sensorService.findByName(measurement.getSensor().getName()).isEmpty()) {
            throw new SensorNotFoundException(
                    "This sensor not registered in the database"
            );
        }

        enrichMeasurement(measurement);
        measurementRepositories.save(measurement);
    }

    public List<Measurement> findAll() {
        return measurementRepositories.findAll();
    }

    public long countByRainingIsTrue() {
       return measurementRepositories.countByRainingIsTrue();
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setMeasurementDateTime(LocalDateTime.now());
    }
}
