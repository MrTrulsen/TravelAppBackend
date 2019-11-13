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


    //Måtte her ta imot city som en del av body på grunn av at apache/tomcat ikke støtter ÆØÅ.
    @RequestMapping(value = "/getActivities", method = RequestMethod.GET)
    public List<DAOActivity> getAllLocations(@RequestBody String city) throws Exception {
        return activityService.getActivityWithId(city);
    }


}

