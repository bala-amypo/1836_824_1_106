package com.example.controller;

import com.example.demo.entity.ComplianceEvaluation;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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
    public ResponseEntity<ComplianceEvaluation> evaluateReading(
            @PathVariable Long readingId) {

        ComplianceEvaluation evaluation = complianceService.evaluateReading(readingId);
        return ResponseEntity.ok(evaluation);
    }

    
    @Operation(summary = "List compliance evaluations for a reading")
    @GetMapping("/reading/{readingId}")
    public ResponseEntity<List<ComplianceEvaluation>> getLogsByReading(
            @PathVariable Long readingId) {

        List<ComplianceEvaluation> evaluations = complianceService.getLogsByReading(readingId);
        return ResponseEntity.ok(evaluations);
    }

  
    @Operation(summary = "Get compliance evaluation log by id")
    @GetMapping("/{id}")
    public ResponseEntity<ComplianceEvaluation> getLogById(
            @PathVariable Long id) {

        ComplianceEvaluation evaluation = complianceService.getLog(id);
        return ResponseEntity.ok(evaluation);
    }
}
