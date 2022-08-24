package com.example.meteorologicalsensorrestapi.service;

import com.example.meteorologicalsensorrestapi.models.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsService sensorsService;

    @Autowired
    public SensorsService(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Transactional
    public void save(Sensor sensor) {

    }
}
