package com.upside.upside.service;

import com.upside.upside.service.dto.Team;

import java.util.Optional;

public interface TeamService {
    Optional<Team> getTeam(int id);
    Optional<Team> updateTeam(Team team);
}
