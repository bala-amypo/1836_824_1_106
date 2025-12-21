package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.List;
import java.util.Optional;
public interface SensorRepository extends JpaRepository<Sensor, Long> {}