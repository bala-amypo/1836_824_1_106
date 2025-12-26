package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
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

    public SensorReadingServiceImpl(SensorReadingRepository readingRepository,
                                    SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        ValidationUtil.requireReadingValue(reading.getReadingValue());

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("sensor not found"));

        reading.setSensor(sensor);
        return readingRepository.save(reading);
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
