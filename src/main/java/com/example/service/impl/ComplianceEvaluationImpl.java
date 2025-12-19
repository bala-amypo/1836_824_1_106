package com.example.demo.service.impl;
import com.example.demo.repository.ComplianceEvaluationRepository;
import com.example.demo.entity.ComplianceEvaluation;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService{

@Autowired
ComplianceEvaluationRepository cer;
public ComplianceEvaluation createComplianceEvaluation(ComplianceEvaluation ce){

    return cer.save(ce);
}


}