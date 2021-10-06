package com.sektorsoftware.schoolscheduler.controller;

import com.sektorsoftware.schoolscheduler.service.ActivityService;
import com.sektorsoftware.schoolscheduler.util.AbstractTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ActivityControllerTest extends AbstractTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ActivityService activityService;

    @Test
    public void shouldReturn200() throws Exception {
        // given
        String payload = FileUtils.readFileToString(new File("src/test/resources/com/sektorsoftware/schoolscheduler/controller/activityRequest_create.json"), StandardCharsets.UTF_8);

        // when && then
        mockMvc.perform(post("/activity/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isOk());
    }
}
