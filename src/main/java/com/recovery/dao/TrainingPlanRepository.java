package com.recovery.dao;

import com.recovery.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {

    Optional<TrainingPlan> findByUserIDAndCreatedDateGreaterThanEqual(String userID, Date date);

    Optional<TrainingPlan> findBySerialNo(Long serialNo);

    List<TrainingPlan> findByUserIDOrderByCreatedDateDesc(String userID);
}
