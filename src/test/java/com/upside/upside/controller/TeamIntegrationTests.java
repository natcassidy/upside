package com.upside.upside.controller;

import com.upside.upside.service.dto.Team;
import com.upside.upside.service.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TeamIntegrationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Sql("/sql/test_team.sql")
    public void testGetTeam_success() {
        ResponseEntity<Team> team = restTemplate.getForEntity("/teams/1", Team.class);

        assertTrue(team.hasBody());
        assertTrue(!team.getStatusCode().isError());
    }

    @Test
    @Sql("/sql/test_team.sql")
    public void testUpdateTeam_success() {
        User user = new User();
        Team team = new Team(1l, "testTeam", 1, user);
        ResponseEntity<Team> teamResponseEntity = restTemplate.postForEntity("/teams", team, Team.class);

        assertTrue(!teamResponseEntity.getStatusCode().isError());
        assertTrue(!teamResponseEntity.getBody().teamName().equals("testTeam"));
    }
}
