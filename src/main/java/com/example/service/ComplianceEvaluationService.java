package com.example.demo.service;

import com.example.demo.entity.ComplianceEvaluation;
import java.util.List;

public interface ComplianceEvaluationService {

    ComplianceEvaluation evaluateReading(Long readingId);

    List<ComplianceEvaluation> getLogsByReading(Long readingId);

    ComplianceEvaluation getLog(Long id);
}
