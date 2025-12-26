package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SensorReading sensorReading;

    private String statusAssigned;

    public void setSensorReading(SensorReading sensorReading) {
        this.sensorReading = sensorReading;
    }

    public void setStatusAssigned(String statusAssigned) {
        this.statusAssigned = statusAssigned;
    }

    public SensorReading getSensorReading() {
        return sensorReading;
    }

    public String getStatusAssigned() {
        return statusAssigned;
    }
}
