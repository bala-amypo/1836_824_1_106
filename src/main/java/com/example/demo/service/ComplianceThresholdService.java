package com.example.demo.service;

import com.example.demo.model.ComplianceThreshold;
import java.util.List;

public interface ComplianceThresholdService {

    ComplianceThreshold createThreshold(ComplianceThreshold threshold);

    ComplianceThreshold getThreshold(Long id);

    ComplianceThreshold getThresholdBySensorType(String sensorType);

    List<ComplianceThreshold> getAllThresholds();
}
