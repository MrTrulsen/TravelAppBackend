package com.travelApp.repository;

import com.travelApp.model.DAOUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);

    @Query(value = "SELECT a.* FROM hotel a INNER JOIN location_hotel_junc l on a.name = l.hotelname WHERE city=:city", nativeQuery = true)
   String findLocationToUser(@Param("city") String city);

    @Query(value = "SELECT currentCity FROM user u WHERE username=:username", nativeQuery = true)
    String findCurrentCityForUser(@Param("username") String username);

    @Query(value = "SELECT displayName FROM user u WHERE username=:username", nativeQuery = true)
    String findDisplayNameForUser(String username);

    @Query(value = "SELECT * FROM user u WHERE username=:username", nativeQuery = true)
    DAOUser getUserDetails(String username);
}