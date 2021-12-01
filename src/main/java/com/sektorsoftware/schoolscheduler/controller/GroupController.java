package com.sektorsoftware.schoolscheduler.controller;

import com.sektorsoftware.schoolscheduler.dto.GroupDto;
import com.sektorsoftware.schoolscheduler.model.Group;
import com.sektorsoftware.schoolscheduler.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/create")
    public Group createGroup(@RequestBody GroupDto groupDto) {
        return groupService.create(groupDto);
    }
}
