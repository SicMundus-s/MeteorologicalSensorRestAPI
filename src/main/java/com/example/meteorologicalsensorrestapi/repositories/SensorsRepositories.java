package com.example.meteorologicalsensorrestapi.repositories;

import com.example.meteorologicalsensorrestapi.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepositories extends JpaRepository<Sensor, Integer> {

}
