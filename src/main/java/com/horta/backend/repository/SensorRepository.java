package com.horta.backend.repository;

import java.util.List;
import com.horta.backend.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
    List<Sensor> findAll();
    List<Sensor> findByName(String name);
    List<Sensor> findBySensor(String sensor);

    @Query("SELECT DISTINCT s.name FROM Sensor s")
    List<String> findAllDistinctMeasureNames();

    @Query("SELECT DISTINCT s.sensor FROM Sensor s")
    List<String> findAllDistinctSensorNames();
}