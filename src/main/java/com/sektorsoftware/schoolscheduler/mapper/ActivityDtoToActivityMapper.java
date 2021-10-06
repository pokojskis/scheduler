package com.sektorsoftware.schoolscheduler.mapper;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ActivityDtoToActivityMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "classroom", source = "classroom")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    Activity map(ActivityDto activityDto);
}
