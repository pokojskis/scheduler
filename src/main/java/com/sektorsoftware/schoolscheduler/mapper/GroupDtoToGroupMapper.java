package com.sektorsoftware.schoolscheduler.mapper;

import com.sektorsoftware.schoolscheduler.dto.GroupDto;
import com.sektorsoftware.schoolscheduler.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GroupDtoToGroupMapper {

    @Mapping(source = "name", target = "name")
    Group map(GroupDto dto);
}
