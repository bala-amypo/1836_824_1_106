package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SensorReading sensorReading;

    @ManyToOne
    private ComplianceThreshold thresholdUsed;

    private String statusAssigned;

    private String remarks;

    private LocalDateTime loggedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SensorReading getSensorReading() { return sensorReading; }
    public void setSensorReading(SensorReading sensorReading) { this.sensorReading = sensorReading; }

    public String getStatusAssigned() { return statusAssigned; }
    public void setStatusAssigned(String statusAssigned) { this.statusAssigned = statusAssigned; }
}
