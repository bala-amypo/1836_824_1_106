package com.example.demo.service;
import jakarta.persistence.service;
import com.example.demo.entity.SensorReading;
@service
public interface SensorReadingService{
    public SensorReading submitReading(Long sensorld, SensorReading reading);
    public SensorReading getReading(Long id)(Throw ResourceNotFoundException);
    public SensorReading getReadingBySensor(Long sensorld);
}