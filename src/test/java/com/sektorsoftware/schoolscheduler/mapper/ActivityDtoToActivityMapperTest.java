package com.sektorsoftware.schoolscheduler.mapper;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import com.sektorsoftware.schoolscheduler.model.AgeGroup;
import com.sektorsoftware.schoolscheduler.model.Classroom;
import com.sektorsoftware.schoolscheduler.model.Day;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivityDtoToActivityMapperTest {

    @Test
    public void shouldMapToActivity() {
        // given
        Activity expected = new Activity();
        expected.setName("Math");
        expected.setClassroom(Classroom.ROOM_1);
        expected.setStartDate(LocalTime.of(10, 0));
        expected.setEndDate(LocalTime.of(10, 30));
        expected.setDay(Day.MONDAY);
        expected.setAgeGroup(AgeGroup.FIVE_YEARS_OLD);

        ActivityDtoToActivityMapper mapper = Mappers.getMapper(ActivityDtoToActivityMapper.class);
        ActivityDto dto = new ActivityDto("Math", Classroom.ROOM_1, LocalTime.of(10, 0), LocalTime.of(10, 30), Day.MONDAY, AgeGroup.FIVE_YEARS_OLD);

        // when
        Activity result = mapper.map(dto);

        // then
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }
}
