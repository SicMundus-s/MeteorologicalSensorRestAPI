package com.example.meteorologicalsensorrestapi.repositories;

import com.example.meteorologicalsensorrestapi.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorsRepositories extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
}
