package com.example.demo.service.impl;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SensorReadingServiceImpl implements SensorReadingService{

@Autowired
SensorReadingRepository srr;
public SensorReading createSensorReading(SensorReading sr){

    return srr.save(sr);
}


}