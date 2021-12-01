package com.sektorsoftware.schoolscheduler.mapper;

import com.sektorsoftware.schoolscheduler.dto.ActivityDto;
import com.sektorsoftware.schoolscheduler.model.Activity;
import org.mapstruct.Mapper;

@Mapper
public interface ActivityDtoToActivityMapper {

    Activity map(ActivityDto activityDto);
}
