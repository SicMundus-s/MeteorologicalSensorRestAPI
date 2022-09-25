package com.example.meteorologicalsensorrestapi.controllers;

import com.example.meteorologicalsensorrestapi.dto.MeasurementDTO;
import com.example.meteorologicalsensorrestapi.dto.MeasurementsResponse;
import com.example.meteorologicalsensorrestapi.models.Measurement;
import com.example.meteorologicalsensorrestapi.service.MeasurementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        measurementService.save(convertorToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public MeasurementsResponse FindAll() {
        return new MeasurementsResponse(measurementService.findAll().stream().map(this::convertorToMeasurementDTO).collect(Collectors.toList()));
    }

    @GetMapping("/rainyDayCount")
    public long showRainyDayCount() {
        return measurementService.countByRainingIsTrue();
    }

    private Measurement convertorToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertorToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

}
