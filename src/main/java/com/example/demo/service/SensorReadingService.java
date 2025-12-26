package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface SensorReadingService {
    SensorReading submitReading(SensorReading reading);
    SensorReading getReading(Long id);
    List<SensorReading> getReadingsBySensor(Long sensorId);
}