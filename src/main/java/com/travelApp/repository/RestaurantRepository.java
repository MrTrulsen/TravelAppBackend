package com.travelApp.repository;

import com.travelApp.model.DAORestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<DAORestaurant, Long> {

    @Query(value = "SELECT a.* FROM restaurant a INNER JOIN location_restaurant_junc l on a.name = l.restaurantName WHERE city=:city", nativeQuery = true)
    List<DAORestaurant> findRestaurantsByCity(String city);
}
