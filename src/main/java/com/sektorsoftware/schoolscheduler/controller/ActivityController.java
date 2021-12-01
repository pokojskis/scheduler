package com.sektorsoftware.schoolscheduler.controller;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.Day;
import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import com.sektorsoftware.schoolscheduler.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/create")
    public Activity create(@RequestBody ActivityDto activityDto) {
        return activityService.create(activityDto);
    }

    @GetMapping
    public List<Activity> getActivitiesForSpecificDay(@RequestParam Day day, @RequestParam AgeGroup ageGroup) {
        return activityService.getForSpecificDay(day, ageGroup);
    }
}
