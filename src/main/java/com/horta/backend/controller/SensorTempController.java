package com.horta.backend.controller;

import java.util.List;

import com.horta.backend.model.BatteryData;
import com.horta.backend.model.Sensor;
import com.horta.backend.repository.BatteryRepository;
import com.horta.backend.repository.SensorRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SensorTempController {

    final SensorRepository sensorRepository;
    final BatteryRepository batteryRepository;

    public SensorTempController(SensorRepository sensorRepository, BatteryRepository batteryRepository) {
        this.sensorRepository = sensorRepository;
        this.batteryRepository = batteryRepository;
    }

    @PostMapping(value = "/add-sensor-data-list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Sensor> addSensorDataList(
            @RequestBody List<Sensor> jsonList) {
        this.sensorRepository.saveAll(jsonList);
        return jsonList;
    }

    @PostMapping(value = "/add-sensor-data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sensor addSingleSensorData(
            @RequestBody Sensor json) {
        this.sensorRepository.save(json);
        return json;
    }

    @PostMapping(value = "/add-battery-level-history", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<BatteryData> addBatteryLevelHistory(
            @RequestBody List<BatteryData> jsonList) {
        this.batteryRepository.saveAll(jsonList);
        return jsonList;
    }

    @PostMapping(value = "/add-battery-level", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BatteryData addSingleBatteryLevel(
            @RequestBody BatteryData json) {
        this.batteryRepository.save(json);
        return json;
    }


    @GetMapping("/read-battery-level")
    public BatteryData readBatteryLevel() {
        return batteryRepository.findTopByOrderByDatetimeDesc().orElse(null);
    }

    @GetMapping("/read-battery-history")
    public List<BatteryData> readBatteryHistory(@RequestParam String board_name) {
        return batteryRepository.findByBoardOrderByDatetime(board_name);
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
