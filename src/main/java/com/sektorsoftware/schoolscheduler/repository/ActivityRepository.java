package com.sektorsoftware.schoolscheduler.repository;

import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.Day;
import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByDayAndAgeGroupOrderByStartDate(Day day, AgeGroup ageGroup);
}
