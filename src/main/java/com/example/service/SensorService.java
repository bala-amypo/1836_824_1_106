package com.example.demo.service;
import jakarta.persistence.service;
import com.example.demo.entity.Sensor;
@Service
public interface SensorService{
    public Sensor createSensor(Long locationId,Sensor sensor);

    public Sensor getSensor(Long id)(Throw ResourceNotFoundException);
    public Sensor getAllSensors();
     
}