package com.horta.backend.repository;

import java.util.List;

import com.horta.backend.model.Sensor;

import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
    List<Sensor> findAll();
}