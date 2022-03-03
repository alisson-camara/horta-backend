package com.horta.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.horta.backend.model.Sensor;
import com.horta.backend.repository.SensorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorTempController {
    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/add-sensor-data")
    public Sensor addSensorData(@RequestParam(value = "value", defaultValue = "10743.00") String value,
            @RequestParam(value = "name", defaultValue = "Luminosidade") String name,
            @RequestParam(value = "sensor", defaultValue = "TSL2561") String sensor,
            @RequestParam(value = "status", defaultValue = "1") String status,
            @RequestParam(value = "unit", defaultValue = "lux") String unit) {
        Sensor sensorData = new Sensor(
                name, unit, sensor, value, Integer.valueOf(status), LocalDateTime.now());
        sensorRepository.save(sensorData);
        return sensorData;
    }

    /*@PostMapping("/add-sensor-data")
    public Sensor addSensorData(Sensor sensorData) {
        sensorRepository.save(sensorData);
        return sensorData;
    }*/
    @GetMapping("/read-sensor-data")
    public List<Sensor> readSensorData() {
        return sensorRepository.findAll();
    }

}
