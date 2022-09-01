package com.example.meteorologicalsensorrestapi.controllers;

import com.example.meteorologicalsensorrestapi.dto.SensorDTO;
import com.example.meteorologicalsensorrestapi.models.Sensor;
import com.example.meteorologicalsensorrestapi.service.SensorsService;
import com.example.meteorologicalsensorrestapi.util.SensorNotRegistrationException;
import com.example.meteorologicalsensorrestapi.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorValidator sensorValidator;
    private final SensorsService sensorsService;
    private final ModelMapper modelMapper;


    @Autowired
    public SensorsController(SensorValidator sensorValidator, SensorsService sensorsService, ModelMapper modelMapper) {
        this.sensorValidator = sensorValidator;
        this.sensorsService = sensorsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {


        sensorValidator.validate(convertToSensor(sensorDTO), bindingResult); // Есть ли сенсоры с такими именами в БД

        if (bindingResult.hasErrors()) {
            StringBuilder errorsMsg = new StringBuilder();
            List<FieldError> fieldError = bindingResult.getFieldErrors();

            for(FieldError error : fieldError) {
                errorsMsg.append("field ").
                        append(error.getField()).
                        append(": ").append(error.getDefaultMessage()).
                        append(";");
            }
            throw new SensorNotRegistrationException(errorsMsg.toString());
        }

        sensorsService.save(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
