package com.example.demo.service.impl;
import com.example.demo.repository.SensorRepository;
import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SensorServiceImpl implements SensorService{

@Autowired
SensorRepository sr;
public Sensor createSensor(Sensor s){

    return sr.save(s);
}


}