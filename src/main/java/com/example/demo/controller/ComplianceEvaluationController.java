package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceService) {
        this.complianceService = complianceService;
    }

    @Operation(summary = "Evaluate reading and create compliance evaluation log")
    @PostMapping("/evaluate/{readingId}")
    public ResponseEntity<ComplianceEvaluation> evaluateReading(@PathVariable Long readingId) {
        ComplianceLog evaluation = complianceService.evaluateReading(readingId);
        return ResponseEntity.ok(evaluation);
    }
    
    @Operation(summary = "List compliance evaluations for a reading")
    @GetMapping("/reading/{readingId}")
    public ResponseEntity<List<ComplianceEvaluation>> getLogsByReading(@PathVariable Long readingId) {
        List<ComplianceLog> evaluations = complianceService.getLogsByReading(readingId);
        return ResponseEntity.ok(evaluations);
    }

    @Operation(summary = "Get compliance evaluation log by id")
    @GetMapping("/{id}")
    public ResponseEntity<ComplianceLog> getLogById(@PathVariable Long id) {
        ComplianceLog evaluation = complianceService.getLog(id);
        if (evaluation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evaluation);
    }
}
