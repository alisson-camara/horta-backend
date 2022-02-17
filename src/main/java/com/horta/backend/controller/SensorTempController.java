package com.horta.backend.controller;

import java.util.List;

import com.horta.backend.Config.ConstantsExamples;
import com.horta.backend.model.Sensor;
import com.horta.backend.repository.SensorRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
public class SensorTempController {

    final
    SensorRepository sensorRepository;

    public SensorTempController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @PostMapping(value = "/add-sensor-data-list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Sensor> addSensorDataList(
            @RequestBody @ApiParam(examples = @Example(value = @ExampleProperty(mediaType = "application/json", value = ConstantsExamples.ADD_SENSOR_DATA_LIST_EXAMPLE))) List<Sensor> jsonList) {
        this.sensorRepository.saveAll(jsonList);
        return jsonList;
    }

    @PostMapping(value = "/add-sensor-data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sensor addSingleSensorData(
            @RequestBody @ApiParam(examples = @Example(value = @ExampleProperty(mediaType = "application/json", value = ConstantsExamples.ADD_SENSOR_DATA_EXAMPLE))) Sensor json) {
        this.sensorRepository.save(json);
        return json;
    }

    @GetMapping("/read-sensor-data")
    public List<Sensor> readSensorData() {
        return sensorRepository.findAll();
    }

    @GetMapping("/list-all-sensors")
    public List<String> listAllSensors() {
        return sensorRepository.findAllDistinctSensorNames();
    }

    @GetMapping("/list-all-categories")
    public List<String> listAllCategories() {
        return sensorRepository.findAllDistinctMeasureNames();
    }

    @GetMapping("/all-from-category")
    public List<Sensor> listFilterByCategory(@RequestParam String category) {
        return sensorRepository.findByName(category);
    }

    @GetMapping("/all-from-sensor")
    public List<Sensor> listFilterBySensor(@RequestParam String sensor) {
        return sensorRepository.findBySensor(sensor);
    }
}
