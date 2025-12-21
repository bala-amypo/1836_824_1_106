package com.example.demo.service;

import com.example.demo.model.ComplianceLog;
import java.util.List;

public interface ComplianceEvaluationService {

    ComplianceLog evaluateReading(Long readingId);

    List<ComplianceLog> getLogsByReading(Long readingId);

    ComplianceLog getLog(Long id);
}
