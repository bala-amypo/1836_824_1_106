package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository complianceThresholdRepository;

    
    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository complianceThresholdRepository) {
        this.complianceThresholdRepository = complianceThresholdRepository;
    }

    @Override
    public ComplianceThreshold createComplianceThreshold(ComplianceThreshold complianceThreshold) {
        return complianceThresholdRepository.save(complianceThreshold);
    }
}
