package com.example.meteorologicalsensorrestapi.repositories;

import com.example.meteorologicalsensorrestapi.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepositories extends JpaRepository<Measurement, Integer> {

    long countByRainingIsTrue();
}
