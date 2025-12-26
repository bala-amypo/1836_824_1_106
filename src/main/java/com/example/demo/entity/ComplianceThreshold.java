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

    // ✅ REQUIRED setters used in tests
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    // (Optional but recommended)
    public String getSensorType() {
        return sensorType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }
}
