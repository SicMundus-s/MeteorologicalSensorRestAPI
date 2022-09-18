package com.example.meteorologicalsensorrestapi.service;

import com.example.meteorologicalsensorrestapi.models.Sensor;
import com.example.meteorologicalsensorrestapi.repositories.SensorsRepositories;
import com.example.meteorologicalsensorrestapi.util.SensorNotRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepositories sensorsRepositories;

    @Autowired
    public SensorsService(SensorsRepositories sensorsRepositories) {
        this.sensorsRepositories = sensorsRepositories;
    }


    @Transactional
    public void save(Sensor sensor) {

        if (sensorsRepositories.findByName(sensor.getName()).isPresent()) { // isPresent - возвращает true если value != null
            throw new SensorNotRegistrationException(
                    "This name is already table"
            );
        }

        sensorsRepositories.save(sensor);
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepositories.findByName(name).stream().findAny();
    }
}
