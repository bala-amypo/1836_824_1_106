package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.repository.ComplianceEvaluationRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final ComplianceEvaluationRepository complianceEvaluationRepository;

    
    public ComplianceEvaluationServiceImpl(ComplianceEvaluationRepository complianceEvaluationRepository) {
        this.complianceEvaluationRepository = complianceEvaluationRepository;
    }

    @Override
    public ComplianceLog createComplianceEvaluation(ComplianceLog complianceEvaluation) {
        return complianceEvaluationRepository.save(complianceEvaluation);
    }
}
