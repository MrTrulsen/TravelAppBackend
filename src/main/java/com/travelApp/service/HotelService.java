package com.travelApp.service;

import com.travelApp.model.DAOHotels;
import com.travelApp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository repository;

    @Autowired
    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all hotels.
     *
     * @return a list of all hotels.
     */
    public List<DAOHotels> getAllHotels() {
        return repository.findAll();
    }

    /**
     * Get all hotels with given city.
     *
     * @return a list of all hotels.
     */
    public List<DAOHotels> getHotelsByCity(String city) {
        return repository.findHotelsByCity(city);
    }

}