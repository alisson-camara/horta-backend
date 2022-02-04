package com.horta.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import antlr.ASTNULLType;
import com.horta.backend.model.Sensor;

import com.horta.backend.repository.SensorRepository;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorTempController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    SensorRepository sensorRepository;

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
