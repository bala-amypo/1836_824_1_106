package com.example.demo.util;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.entity.Location;
import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;

public class ValidationUtil {

    private ValidationUtil() {
       
    }

   

    public static void validateSensor(Sensor sensor) {
        if (sensor == null) {
            throw new IllegalArgumentException("not found");
        }
        if (sensor.getSensorType() == null || sensor.getSensorType().isEmpty()) {
            throw new IllegalArgumentException("sensorType missing");
        }
    }

   

    public static void validateLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("not found");
        }
        if (location.getRegion() == null || location.getRegion().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
    }

  

    public static void validateThreshold(ComplianceThreshold threshold) {
        if (threshold == null) {
            throw new IllegalArgumentException("not found");
        }
        if (threshold.getMinValue() != null
                && threshold.getMaxValue() != null
                && threshold.getMinValue() >= threshold.getMaxValue()) {
            throw new IllegalArgumentException("minvalue invalid");
        }
    }

    

    public static void validateSensorReading(SensorReading reading) {
        if (reading == null) {
            throw new IllegalArgumentException("not found");
        }
        if (reading.getReadingValue() == null) {
            throw new IllegalArgumentException("readingvalue missing");
        }
    }
}
