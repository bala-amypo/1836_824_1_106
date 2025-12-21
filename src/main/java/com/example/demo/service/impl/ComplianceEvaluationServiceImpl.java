package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final SensorReadingRepository readingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository logRepository;

    public ComplianceEvaluationServiceImpl(
            SensorReadingRepository readingRepository,
            ComplianceThresholdRepository thresholdRepository,
            ComplianceLogRepository logRepository) {
        this.readingRepository = readingRepository;
        this.thresholdRepository = thresholdRepository;
        this.logRepository = logRepository;
    }

    @Override
    public ComplianceLog evaluateReading(Long readingId) {
        SensorReading reading = readingRepository.findById(readingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Reading not found with id: " + readingId));

        ComplianceThreshold threshold = thresholdRepository
                .findBySensorType(reading.getSensor().getSensorType())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threshold not found for sensor type"));

        boolean compliant =
                reading.getReadingValue() >= threshold.getMinValue() &&
                reading.getReadingValue() <= threshold.getMaxValue();

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        log.setCompliant(compliant);
        log.setEvaluatedAt(LocalDateTime.now());
        log.setMessage(compliant ? "Within limits" : "Out of compliance");

        return logRepository.save(log);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return logRepository.findBySensorReadingId(readingId);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Compliance log not found with id: " + id));
    }
}
