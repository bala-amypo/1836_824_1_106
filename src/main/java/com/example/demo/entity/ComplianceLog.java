package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class ComplianceLog {
    @Id
    private Long id;
    private SensorReading sensorReading;
    private ComplianceThreshold thresholdUsed;
    private String statusAssigned;
    private String remarks;
    private LocalDateTime loggedAt;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public SensorReading getSensorReading() {
        return sensorReading;
    }

    public void setSensorReading(SensorReading sensorReading) {
        this.sensorReading = sensorReading;
    }


    public ComplianceThreshold getThresholdUsed() {
        return thresholdUsed;
    }

    public void setThresholdUsed(ComplianceThreshold thresholdUsed) {
        this.thresholdUsed = thresholdUsed;
    }


    public String getStatusAssigned() {
        return statusAssigned;
    }

    public void setStatusAssigned(String statusAssigned) {
        this.statusAssigned = statusAssigned;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
    public ComplianceLog(Long id, SensorReading sensorReading, ComplianceThreshold thresholdUsed, String statusAssigned, String remarks, LocalDateTime loggedAt){
    this.id=id;
    this.sensorReading=sensorReading;
    this.thresholdUsed=thresholdUsed;
    this.statusAssigned=statusAssigned;
    this.remarks=remarks;
    this.loggedAt=loggedAt;

}
public ComplianceLog(){
    
}
}