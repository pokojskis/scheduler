package com.sektorsoftware.schoolscheduler.repository;

import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.Classroom;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ActivityRepositoryTest {

    @Autowired
    ActivityRepository activityRepository;

    @After
    public void tearDown() {
        activityRepository.deleteAll();
    }

    @Test
    public void shouldSaveActivity() {
        // given
        Activity activity = new Activity();
        activity.setName("Math");
        activity.setClassroom(Classroom.ROOM_1);
        activity.setStartDate(LocalTime.of(10, 0));
        activity.setEndDate(LocalTime.of(10, 30));

        // when
        Activity result = activityRepository.save(activity);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Math");
        assertThat(result.getClassroom()).isEqualTo(Classroom.ROOM_1);
        assertThat(result.getStartDate()).isEqualTo(LocalTime.of(10 ,0));
        assertThat(result.getEndDate()).isEqualTo(LocalTime.of(10, 30));

        List<Activity> all = activityRepository.findAll();
        assertThat(all).hasSize(1);
    }
}
