package com.example.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    @Autowired
    private SensorReadingService readingService;

   
    @PostMapping("/{sensorId}")
    public SensorReading submitReading(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        return readingService.submitReading(sensorId, reading);
    }

    
    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> getReadingsBySensor(@PathVariable Long sensorId) {
        return readingService.getReadingsBySensor(sensorId);
    }

    
    @GetMapping("/{id}")
    public SensorReading getReading(@PathVariable Long id) {
        return readingService.getReading(id);
    }
}
