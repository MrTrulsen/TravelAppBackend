package com.travelApp.service;

import com.travelApp.model.DAORestaurant;
import com.travelApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all restaurants with given city.
     *
     * @return a list of all restaurants.
     */
    public List<DAORestaurant> getRestaurantsByCity(String city) {
        return repository.findRestaurantsByCity(city);
    }

}