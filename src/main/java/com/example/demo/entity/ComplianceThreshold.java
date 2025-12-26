package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private String severityLevel;
    private Double minValue;
    private Double maxValue;

    // REQUIRED by tests
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    // Recommended getters
    public String getSensorType() {
        return sensorType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }
}
