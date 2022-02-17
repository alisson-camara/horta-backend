package com.horta.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    @JsonProperty
    private String name;
    @Column
    @JsonProperty
    private String unit;
    @Column
    @JsonProperty
    private String sensor;
    @Column
    @JsonProperty
    private Float value;
    @Column
    @JsonProperty
    private Integer status;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date datetime;

}

