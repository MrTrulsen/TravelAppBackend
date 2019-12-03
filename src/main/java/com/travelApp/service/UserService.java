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

    /**
     * Get displayName for user
     *
     * @return the display name
     */
    public String getDisplayNameForUser(String username) { return repository.findDisplayNameForUser(username);
    }

    /**
     * Get UserDetails for user
     *
     * @return the user details
     */
    public DAOUser getUserDetails(String username) { return repository.getUserDetails(username);
    }

    /**
     * Get UserAvatar for user
     *
     * @return the user avatar
     */
    public String getUserAvatarImageUrl(String username) { return repository.getUserImageAvatarUrl(username);
    }

    /**
     * Get UserOccupation for user
     *
     * @return the user occupation
     */
    public String getUserOccupation(String username) { return repository.getUserOccupation(username);
    }

    /**
     * Set currentCity for user
     */
    public void setNewCurrentCity(String username, String city) { repository.setCurrentCity(username, city);
    }


}
