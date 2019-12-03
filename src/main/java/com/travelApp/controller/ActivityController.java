package com.travelApp.controller;

import com.travelApp.model.DAOActivity;
import com.travelApp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping(value = "/getFavorites")
    public List<DAOActivity> getFavorites() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return activityService.getUserFavorites(auth.getName());
    }

    @DeleteMapping(value = "/removeFavorites")
    public void removeFavoriteActivity(@RequestParam String activityName){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        activityService.removeUserFavorites(auth.getName(), activityName);
    }

    @PostMapping(value = "/addFavorites")
    public void addFavoriteActivity(@RequestParam String activityName){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        activityService.addUserFavorites(auth.getName(), activityName);
    }

}

