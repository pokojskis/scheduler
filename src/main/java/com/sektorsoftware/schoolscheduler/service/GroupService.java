package com.sektorsoftware.schoolscheduler.service;

import com.sektorsoftware.schoolscheduler.dto.GroupDto;
import com.sektorsoftware.schoolscheduler.mapper.GroupDtoToGroupMapper;
import com.sektorsoftware.schoolscheduler.model.Group;
import com.sektorsoftware.schoolscheduler.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group create(GroupDto groupDto) {

        GroupDtoToGroupMapper mapper = Mappers.getMapper(GroupDtoToGroupMapper.class);
        Group group = mapper.map(groupDto);

        return groupRepository.save(group);
    }
}
