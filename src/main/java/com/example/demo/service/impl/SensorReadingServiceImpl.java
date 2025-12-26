package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository readingRepository;
    private final SensorRepository sensorRepository;
    private final ComplianceLogRepository complianceLogRepository;

    public SensorReadingServiceImpl(
            SensorReadingRepository readingRepository,
            SensorRepository sensorRepository,
            ComplianceLogRepository complianceLogRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
        this.complianceLogRepository = complianceLogRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        ValidationUtil.requireReadingValue(reading.getReadingValue());

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("sensor not found"));

        reading.setSensor(sensor);
        SensorReading saved = readingRepository.save(reading);

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(saved);
        log.setStatusAssigned("EVALUATED");
        complianceLogRepository.save(log);

        return saved;
    }

    @Override
    public SensorReading submitReading(SensorReading reading) {
        ValidationUtil.requireReadingValue(reading.getReadingValue());

        SensorReading saved = readingRepository.save(reading);

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(saved);
        log.setStatusAssigned("EVALUATED");
        complianceLogRepository.save(log);

        return saved;
    }

    @Override
    public SensorReading getReading(Long id) {
        return readingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reading not found"));
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return readingRepository.findBySensor_Id(sensorId);
    }
}
