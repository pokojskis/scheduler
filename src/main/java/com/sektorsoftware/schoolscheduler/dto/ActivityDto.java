package com.sektorsoftware.schoolscheduler.dto;

import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import com.sektorsoftware.schoolscheduler.model.Classroom;
import com.sektorsoftware.schoolscheduler.model.Day;

import java.time.LocalTime;

public record ActivityDto(String name, Classroom classroom, LocalTime startDate, LocalTime endDate, Day day, AgeGroup ageGroup) {}
