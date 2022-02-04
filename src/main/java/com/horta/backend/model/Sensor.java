package com.horta.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Sensor {
    @Id
    @GeneratedValue
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String unit;
    @JsonProperty
    private String sensor;
    @JsonProperty
    private Float value;
    @JsonProperty
    private Integer status;
    @JsonProperty
    private String datetime;

    public Sensor(String name, String unit, String sensor, String value, String status, String datetime) {
        this.name = name;
        this.unit = unit;
        this.sensor = sensor;
        this.value = Float.parseFloat(value);
        this.status = Integer.parseInt(status);
        this.datetime = datetime;
    }
}

