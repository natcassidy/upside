package com.upside.upside.controller;

import com.upside.upside.service.dto.Team;
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
}
