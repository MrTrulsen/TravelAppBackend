package com.travelApp.controller;

import com.travelApp.model.DAOUser;
import com.travelApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getCurrentCity")
    public String getCurrentCity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getCurrentCityForUser(auth.getName());
    }

    @GetMapping(value = "/getDisplayName")
    public String getDisplayName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getDisplayNameForUser(auth.getName());
    }

    // TODO FIX this.
    @GetMapping(value = "/getUserDetails")
    public DAOUser getUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserDetails(auth.getName());
    }

}


