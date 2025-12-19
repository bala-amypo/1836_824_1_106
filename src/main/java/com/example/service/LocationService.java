package com.example.demo.service;
import jakarta.persistence.service;
import com.example.demo.entity.Location;
@Location
public interface LocationService{
    public Location createLocation(Location location);
    public Location getLoacation(Long id)(Throw ResourceNotFoundException);
    public Location getAllLocations();
}