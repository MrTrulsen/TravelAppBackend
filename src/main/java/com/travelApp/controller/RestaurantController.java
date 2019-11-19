package com.travelApp.controller;

import com.travelApp.model.DAORestaurant;
import com.travelApp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/getRestaurants")
    public List<DAORestaurant> getAllLocations(@RequestParam String city) throws Exception {
        return restaurantService.getRestaurantsByCity(city);
    }

}
