package com.example.demo.service;
import jakarta.persistence.service;
import com.example.demo.entity.ComplianceThreshold;
@Service
public interface ComplianceThresholdService{
    public ComplianceThreshold createThreshold(ComplianceThreshold threshold);
    public ComplianceThreshold getThreshold(Long id);
    public ComplianceThreshold getThresholdBySensorType(String sensor Type);
    public ComplianceThreshold getAllThreshold();
    
}