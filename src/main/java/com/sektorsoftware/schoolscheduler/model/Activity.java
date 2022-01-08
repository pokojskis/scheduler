package com.sektorsoftware.schoolscheduler.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "ACTIVITY")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Classroom classroom;

    private LocalTime startDate;

    private LocalTime endDate;

    @Enumerated(EnumType.STRING)
    private Day day;

    private AgeGroup ageGroup;
}
