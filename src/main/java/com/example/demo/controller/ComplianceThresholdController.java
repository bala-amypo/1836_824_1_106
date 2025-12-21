package com.example.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    @Autowired
    private ComplianceThresholdService thresholdService;

   
    @PostMapping("/")
    public ComplianceThreshold createThreshold(@RequestBody ComplianceThreshold threshold) {
        return thresholdService.createThreshold(threshold);
    }

    
    @GetMapping("/")
    public List<ComplianceThreshold> getAllThresholds() {
        return thresholdService.getAllThresholds();
    }

    
    @GetMapping("/{id}")
    public ComplianceThreshold getThreshold(@PathVariable Long id) {
        return thresholdService.getThreshold(id);
    }

    
    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getThresholdBySensorType(@PathVariable String sensorType) {
        return thresholdService.getThresholdBySensorType(sensorType);
    }
}
