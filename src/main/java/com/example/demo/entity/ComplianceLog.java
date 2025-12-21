package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean compliant;
    private String message;
    private LocalDateTime evaluatedAt;

    @ManyToOne
    private SensorReading sensorReading;

    public ComplianceLog() {}

    public Long getId() { return id; }
    public Boolean getCompliant() { return compliant; }
    public void setCompliant(Boolean compliant) { this.compliant = compliant; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
    public void setEvaluatedAt(LocalDateTime evaluatedAt) { this.evaluatedAt = evaluatedAt; }
    public SensorReading getSensorReading() { return sensorReading; }
    public void setSensorReading(SensorReading sensorReading) { this.sensorReading = sensorReading; }
}
