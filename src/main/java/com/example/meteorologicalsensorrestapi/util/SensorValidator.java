package com.example.meteorologicalsensorrestapi.util;

import com.example.meteorologicalsensorrestapi.models.Sensor;
import com.example.meteorologicalsensorrestapi.service.SensorsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;

    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if(sensorsService.findByName(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "400", "This name is already table");
        }
    }
}
