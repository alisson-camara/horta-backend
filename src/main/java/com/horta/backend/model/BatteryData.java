package com.horta.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.horta.backend.Config.ConstantsExamples;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class BatteryData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    @JsonProperty
    private String board;
    @Column
    @JsonProperty
    private Integer level;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(
        value = "Time when the sensor data was aquired",
        name = "datetime",
        dataType = "String",
        example = "2022-01-29 10:45:21")
    private Date datetime;

}

