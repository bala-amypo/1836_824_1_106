package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compliance_threshold")
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minValue;
    private Double maxValue;
    private String parameter;

   
    public Long getId() {
        return id;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public String getParameter() {
        return parameter;
    }

 
   
    public void setId(Long id) {
        this.id = id;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
