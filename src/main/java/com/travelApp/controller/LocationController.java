package com.travelApp.controller;

import com.travelApp.model.DAOLocation;
import com.travelApp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<DAOLocation> getAllLocations() throws Exception {
        return locationService.getAllLocations();
    }

}
