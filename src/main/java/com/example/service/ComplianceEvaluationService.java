package com.example.demo.service;
import jakarta.persistence.service;
import com.example.demo.entity.ComplianceEvaluation;
@Service
public interface ComplianceEvaluationService{
    public ComplianceEvaluation evaluateReading(Long readingId);
    public ComplianceEvaluation getLogsByReading(Long readingId);
    public ComplianceEvaluation getLog(Long id);
    
}