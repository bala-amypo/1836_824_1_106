package com.example.demo.service.impl;
import com.example.demo.repository.LocationRepository;
import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class LocationServiceImpl implements LocationService{

@Autowired
LocationRepository lr;
public Location createLocation(Location l){

    return lr.save(l);
}


}