package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private Double minValue;
    private Double maxValue;
    private String unit;

    public ComplianceThreshold() {}

    public Long getId() { return id; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public Double getMinValue() { return minValue; }
    public void setMinValue(Double minValue) { this.minValue = minValue; }
    public Double getMaxValue() { return maxValue; }
    public void setMaxValue(Double maxValue) { this.maxValue = maxValue; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
}
