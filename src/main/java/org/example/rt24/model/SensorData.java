package org.example.rt24.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "sensor_id", nullable = false)
    @Getter
    @Setter
    private Integer sensorId;

    @Column(name = "format", nullable = false, length = 50)
    @Getter
    @Setter
    private String format;

    @Column(name = "unit", nullable = false, length = 50)
    @Getter
    @Setter
    private String unit;

    @Column(name = "measurement", nullable = false)
    @Getter
    @Setter
    private double measurement;

    @Column(name = "record_time", nullable = false)
    @Getter
    @Setter
    private LocalDateTime record_time;
}