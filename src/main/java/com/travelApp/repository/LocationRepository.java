package com.travelApp.repository;

import com.travelApp.model.DAOLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<DAOLocation, Long> {

}
