package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private Double minValue;
    private Double maxValue;
    private String severityLevel;
    private LocalDateTime createdAt;

    public ComplianceThreshold() {}

    public ComplianceThreshold(Long id, String sensorType, Double minValue,
                               Double maxValue, String severityLevel,
                               LocalDateTime createdAt) {
        this.id = id;
        this.sensorType = sensorType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.severityLevel = severityLevel;
        this.createdAt = createdAt;
    }

    
}

public ComplianceThreshold(){

}
}
