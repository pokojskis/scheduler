package com.sektorsoftware.schoolscheduler.service;

import com.sektorsoftware.schoolscheduler.dto.GroupDto;
import com.sektorsoftware.schoolscheduler.model.Group;
import com.sektorsoftware.schoolscheduler.repository.GroupRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GroupServiceTest {

    @Autowired
    GroupService groupService;

    @Autowired
    GroupRepository groupRepository;

    @After
    public void tearDown() {
        groupRepository.deleteAll();
    }

    @Test
    public void shouldSaveGroup() {
        // given
        GroupDto groupDto = new GroupDto("5-LATKI");
        Group expected = new Group();
        expected.setId(1L);
        expected.setName("5-LATKI");

        // when
        Group result = groupService.create(groupDto);

        // then
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);

        List<Group> all = groupRepository.findAll();
        assertThat(all).hasSize(1);
    }
}
