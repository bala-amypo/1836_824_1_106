package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sensor sensor;

    private Double value;

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Double getValue() {
        return value;
    }
}
