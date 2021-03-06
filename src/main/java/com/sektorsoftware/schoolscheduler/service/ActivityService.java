package com.sektorsoftware.schoolscheduler.service;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.mapper.ActivityDtoToActivityMapper;
import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.Day;
import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import com.sektorsoftware.schoolscheduler.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public Activity create(ActivityDto activityDto) {
        ActivityDtoToActivityMapper mapper = Mappers.getMapper(ActivityDtoToActivityMapper.class);

        Activity activity = mapper.map(activityDto);

        return activityRepository.save(activity);
    }

    public List<Activity> getForSpecificDay(Day day, AgeGroup ageGroup) {
        return activityRepository.findAllByDayAndAgeGroupOrderByStartDate(day, ageGroup);
    }
}
