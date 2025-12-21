package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double readingValue;
    private LocalDateTime readingTime;

    @ManyToOne
    private Sensor sensor;

    public SensorReading() {}

    public Long getId() { return id; }
    public Double getReadingValue() { return readingValue; }
    public void setReadingValue(Double readingValue) { this.readingValue = readingValue; }
    public LocalDateTime getReadingTime() { return readingTime; }
    public void setReadingTime(LocalDateTime readingTime) { this.readingTime = readingTime; }
    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }
}
