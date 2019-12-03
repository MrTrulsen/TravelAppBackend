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
     * Get activities within a city.
     *
     * @return a list of all activities in a city.
     */
    public List<DAOActivity> getActivityByCity(String city) {
        return repository.findActivityByCity(city);
    }

    /**
     * Get users favorite activities.
     *
     * @return a list of favorite activities.
     */
    public List<DAOActivity> getUserFavorites(String username) { return repository.getUserFavorites(username);
    }

    /**
     * Remove users favorite activities.
     */
    public void removeUserFavorites(String username, String activityName) { repository.removeUserFavorites(activityName,username);
    }

    /**
     * Add user favorite activity.
     * @param username
     * @param activityName
     */
    public void addUserFavorites(String username, String activityName) { repository.addUserFavorites(activityName,username);
    }
}
