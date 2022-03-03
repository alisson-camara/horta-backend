package com.horta.backend.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor {
    private String name;
    private String unit;
    private String sensor;
    private String value;
    private Integer status;
    @Id
    @Column(name = "datetime")
    private LocalDateTime datetime;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getSensor() {
        return sensor;
    }
    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getDatetime() {
        return datetime;
    }
    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
    public void setDatetime(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.datetime = LocalDateTime.parse(datetime, formatter);
    }
    @Override
    public String toString() {
        return "Sensor [datetime=" + datetime + ", name=" + name + ", sensor=" + sensor + ", status=" + status
                + ", unit=" + unit + ", value=" + value + "]";
    }
    public Sensor(String name, String unit, String sensor, String value, Integer status, LocalDateTime datetime) {
        this.name = name;
        this.unit = unit;
        this.sensor = sensor;
        this.value = value;
        this.status = status;
        this.datetime = datetime;
    }
    public Sensor() {
    }
    
}

