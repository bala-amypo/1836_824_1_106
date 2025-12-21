package com.example.demo.controller;

import com.example.demo.model.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService service;

    public ComplianceEvaluationController(ComplianceEvaluationService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{readingId}")
    public ComplianceLog evaluateReading(@PathVariable Long readingId) {
        return service.evaluateReading(readingId);
    }

    @GetMapping("/logs/reading/{readingId}")
    public List<ComplianceLog> getLogsByReading(@PathVariable Long readingId) {
        return service.getLogsByReading(readingId);
    }

    @GetMapping("/logs/{id}")
    public ComplianceLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }
}
