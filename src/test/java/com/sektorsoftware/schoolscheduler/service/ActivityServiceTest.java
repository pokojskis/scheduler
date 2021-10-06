package com.sektorsoftware.schoolscheduler.service;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.Classroom;
import com.sektorsoftware.schoolscheduler.repository.ActivityRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityRepository activityRepository;

    @After
    public void tearDown() {
        activityRepository.deleteAll();
    }

    @Test
    public void shouldSaveActivity() {
        // given
        ActivityDto dto = new ActivityDto("Math", Classroom.ROOM_1, LocalTime.of(10, 0), LocalTime.of(10, 30));
        Activity expected = new Activity();
        expected.setId(1L);
        expected.setName("Math");
        expected.setClassroom(Classroom.ROOM_1);
        expected.setStartDate(LocalTime.of(10, 0));
        expected.setEndDate(LocalTime.of(10, 30));

        // when
        Activity result = activityService.create(dto);

        // then
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);

        List<Activity> all = activityRepository.findAll();
        assertThat(all).hasSize(1);
    }
}
