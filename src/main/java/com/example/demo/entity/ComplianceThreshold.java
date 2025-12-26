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

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public String getSensorType() {
        return sensorType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }
}
