package com.sektorsoftware.schoolscheduler.repository;

import com.sektorsoftware.schoolscheduler.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
