package com.travelApp.controller;

import com.travelApp.model.DAOActivity;
import com.travelApp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping(value = "/getActivities")
    public List<DAOActivity> getAllLocations(@RequestParam String city) throws Exception {
        return activityService.getActivityByCity(city);
    }

}

