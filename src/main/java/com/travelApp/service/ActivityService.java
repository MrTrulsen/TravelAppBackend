package com.travelApp.service;

import com.travelApp.model.DAOActivity;
import com.travelApp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository repository;

    @Autowired
    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all activities.
     *
     * @return a list of all activities.
     */
    public List<DAOActivity> getAllActivities() {
        return repository.findAll();
    }

    /**
     * Get all activities.
     *
     * @return a list of all activities.
     */
    public List<DAOActivity> getActivityWithId(String city) {
        return repository.findByActivityId(city);
    }

}
