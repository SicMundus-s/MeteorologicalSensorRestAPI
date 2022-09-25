package com.example.meteorologicalsensorrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeteorologicalSensorRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteorologicalSensorRestApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() { // bin in the context of spring
        return new ModelMapper();

    }


}
