package com.sektorsoftware.schoolscheduler.repository;

import com.sektorsoftware.schoolscheduler.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
