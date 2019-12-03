package com.travelApp.repository;

import com.travelApp.model.DAOActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<DAOActivity, Long> {

    @Query(value = "SELECT a.* FROM activity a INNER JOIN locat_activ_junc l on a.activityId = l.activityId WHERE location_city=:city", nativeQuery = true)
    List<DAOActivity> findActivityByCity(@Param("city") String city);

    @Query(value = "SELECT a.* FROM activity a INNER JOIN favorite_activ_junc l on a.activityId = l.activityId WHERE username=:username", nativeQuery = true)
    List<DAOActivity> getUserFavorites(String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE f FROM favorite_activ_junc f INNER JOIN activity a on f.activityId = a.activityId WHERE name=:activityName AND username=:username", nativeQuery = true)
    void removeUserFavorites(@Param("activityName") String activityName, @Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO favorite_activ_junc (username, activityId) VALUES (:username, (SELECT activityId FROM activity WHERE name=:activityName))", nativeQuery = true)
    void addUserFavorites(@Param("activityName")String activityName, @Param("username") String username);
}
