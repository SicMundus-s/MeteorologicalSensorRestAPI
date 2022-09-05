package com.example.meteorologicalsensorrestapi.controllers;

import com.example.meteorologicalsensorrestapi.dto.MeasurementDTO;
import com.example.meteorologicalsensorrestapi.models.Measurement;
import com.example.meteorologicalsensorrestapi.service.MeasurementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final ModelMapper modelMapper;
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(ModelMapper modelMapper, MeasurementService measurementService) {
        this.modelMapper = modelMapper;
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addingMeasurementsMade(@RequestBody @Valid MeasurementDTO measurementDTO) {
        measurementService.save(convertorDTO(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Measurement convertorDTO(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }


}
