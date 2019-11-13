package com.travelApp.repository;

import com.travelApp.model.DAOHotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<DAOHotels, Long> {

    @Query(value = "SELECT a.* FROM hotel a INNER JOIN location_hotel_junc l on a.name = l.hotelname WHERE city=:city", nativeQuery = true)
    List<DAOHotels> findHotelsByCity(@Param("city") String city);
}
