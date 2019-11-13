package com.travelApp.controller;

import com.travelApp.model.DAOHotels;
import com.travelApp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "/getHotels")
    public List<DAOHotels> getAllLocations(@RequestParam String city) throws Exception {
        return hotelService.getHotelsByCity(city);
    }

}

