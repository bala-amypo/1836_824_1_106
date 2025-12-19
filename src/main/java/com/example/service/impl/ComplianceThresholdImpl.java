package com.example.demo.service.impl;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService{

@Autowired
ComplianceThresholdRepository ctr;
public ComplianceThreshold createComplianceThreshold(ComplianceThreshold ct){

    return ctr.save(ct);
}


}