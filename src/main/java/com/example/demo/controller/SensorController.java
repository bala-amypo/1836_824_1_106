package com.example.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    
    @PostMapping("/{locationId}")
    public Sensor createSensor(@PathVariable Long locationId, @RequestBody Sensor sensor) {
        return sensorService.createSensor(locationId, sensor);
    }

    
    @GetMapping("/")
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

   
    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable Long id) {
        return sensorService.getSensor(id);
    }
}
