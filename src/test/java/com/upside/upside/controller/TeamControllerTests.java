package com.upside.upside.controller;

import com.upside.upside.service.TeamService;
import com.upside.upside.service.dto.Team;
import com.upside.upside.service.dto.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
public class TeamControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TeamService teamService;

    @Test
    public void testGetTeam_returnSuccess() throws Exception {
        Team team = new Team(1l, "Test", 1, new User());
        when(teamService.getTeam(anyInt())).thenReturn(Optional.of(team));

        mockMvc.perform(get("/teams/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.teamName").value("Test"))
                .andExpect(jsonPath("$.id").value(1l));
    }

    @Test
    public void testGetTeam_returnFailure() throws Exception {
        mockMvc.perform(get("/teams/2"))
                .andExpect(status().isNotFound());
    }
}
