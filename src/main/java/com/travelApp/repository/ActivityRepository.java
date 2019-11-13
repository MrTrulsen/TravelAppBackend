package com.travelApp.repository;

import com.travelApp.model.DAOActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<DAOActivity, Long> {

    @Query(value = "SELECT a.* FROM activity a INNER JOIN locat_activ_junc l ON a.activityId = l.activityId WHERE location_city=:city", nativeQuery = true)
    List<DAOActivity> findByActivityId(@Param("city") String city);
}
