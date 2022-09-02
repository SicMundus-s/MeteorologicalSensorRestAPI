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

    private final SensorsService sensorsService;
    private final ModelMapper modelMapper;


    @Autowired
    public SensorsController(SensorsService sensorsService, ModelMapper modelMapper) {
        this.sensorsService = sensorsService;
        this.modelMapper = modelMapper;
    }

    /*
    Возможна реализация через bindingResult, в таком случае нам нужно передать его в аргументе и с помощью стрингБилдера
    конкатенировать строки из листа ошибок(FieldError) и выкинуть исключение с сообщением ошибки в ПОЛЯХ.
    Сейчас ошибки с полей ловятся в ExceptionApiHandler таким образом ответственность за обработку ошибки ложится не на контроллер
     */
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationSensor(@RequestBody @Valid SensorDTO sensorDTO) {

        sensorsService.save(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
