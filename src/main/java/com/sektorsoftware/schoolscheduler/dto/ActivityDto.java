package com.sektorsoftware.schoolscheduler.dto;

import com.sektorsoftware.schoolscheduler.model.Classroom;

import java.time.LocalTime;

public record ActivityDto(String name, Classroom classroom, LocalTime startDate, LocalTime endDate) {}
