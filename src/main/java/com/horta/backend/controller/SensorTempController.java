package com.horta.backend.controller;

import java.util.List;
import com.horta.backend.model.Sensor;
import com.horta.backend.repository.SensorRepository;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorTempController {

    private final ProducerTemplate producerTemplate;

    final
    SensorRepository sensorRepository;

    public SensorTempController(ProducerTemplate producerTemplate, SensorRepository sensorRepository) {
        this.producerTemplate = producerTemplate;
        this.sensorRepository = sensorRepository;
    }

    @PostMapping(value = "/add-sensor-data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addSensorData(@RequestBody String json){
        producerTemplate.start();
        producerTemplate.requestBody("direct:storeSensorData", json);
        producerTemplate.stop();
        return "ok";
    }

    @GetMapping("/read-sensor-data")
    public List<Sensor> readSensorData() {
        return sensorRepository.findAll();
    }
}
