package com.example.demo.service.impl;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService{

@Autowired
AssignmentEvaluationRepository aer;
public AssignmentEvaluation createAssignmentEvaluation(AssignmentEvaluation ae){

    return aer.save(ae);
}


}