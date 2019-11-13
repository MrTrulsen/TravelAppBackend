package com.travelApp.service;

import com.travelApp.model.DAOLocation;
import com.travelApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository repository;

    @Autowired
    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all locations.
     *
     * @return a list of all locations.
     */
    public List<DAOLocation> getAllLocations() {
        return repository.findAll();
    }

}
