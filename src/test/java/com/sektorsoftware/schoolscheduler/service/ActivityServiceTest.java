package com.sektorsoftware.schoolscheduler.service;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import com.sektorsoftware.schoolscheduler.model.Classroom;
import com.sektorsoftware.schoolscheduler.model.Day;
import com.sektorsoftware.schoolscheduler.repository.ActivityRepository;
import com.sektorsoftware.schoolscheduler.util.AbstractTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ActivityServiceTest extends AbstractTest {

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityRepository activityRepository;

    @AfterEach
    public void tearDown() {
        activityRepository.deleteAll();
    }

    @Test
    public void shouldSaveActivity() {
        // given
        String name = "Math";
        LocalTime startDate = LocalTime.of(10, 0);
        LocalTime endDate = LocalTime.of(10, 30);
        ActivityDto dto = new ActivityDto(name, Classroom.ROOM_1, startDate, endDate, Day.MONDAY, AgeGroup.FIVE_YEARS_OLD);

        // when
        Activity result = activityService.create(dto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getDay()).isEqualByComparingTo(Day.MONDAY);
        assertThat(result.getAgeGroup()).isEqualByComparingTo(AgeGroup.FIVE_YEARS_OLD);
        assertThat(result.getClassroom()).isEqualByComparingTo(Classroom.ROOM_1);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getStartDate()).isEqualTo(startDate);
        assertThat(result.getEndDate()).isEqualTo(endDate);

        List<Activity> all = activityRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    public void shouldGetAllActivitiesForSpecificDay() {
        // given
        List<Activity> activities = generator.objects(Activity.class, 10).toList();
        for (Activity activity : activities) {
            activity.setDay(Day.MONDAY);
            activity.setAgeGroup(AgeGroup.FIVE_YEARS_OLD);
        }
        activityRepository.saveAll(activities);

        // when
        List<Activity> result = activityService.getForSpecificDay(Day.MONDAY, AgeGroup.FIVE_YEARS_OLD);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(10);
        for (Activity resultActivity : result) {
            assertThat(resultActivity.getDay()).isEqualTo(Day.MONDAY);
            assertThat(resultActivity.getAgeGroup()).isEqualTo(AgeGroup.FIVE_YEARS_OLD);
        }
    }
}
