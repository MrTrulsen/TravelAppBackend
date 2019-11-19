package com.travelApp.service;

import com.travelApp.model.DAOUser;
import com.travelApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Get currentCity for user
     *
     * @return the current city
     */
    public String getCurrentCityForUser(String username) {
        return repository.findCurrentCityForUser(username);
    }

    public String getDisplayNameForUser(String username) { return repository.findDisplayNameForUser(username);
    }

    public DAOUser getUserDetails(String username) { return repository.getUserDetails(username);
    }

    public String getUserAvatarImageUrl(String username) { return repository.getUserImageAvatarUrl(username);
    }

    public String getUserOccupation(String username) { return repository.getUserOccupation(username);
    }
}
