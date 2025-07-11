package com.upside.upside.service;

import com.upside.upside.data.TeamRepository;
import com.upside.upside.service.dto.Team;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    TeamRepository teamRepository;
    TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Optional<Team> getTeam(int id) {
        Optional<com.upside.upside.data.Team> teamEntity = teamRepository.findById(id);

        if(teamEntity.isPresent()) {
            Team team = teamMapper.convertToDto(teamEntity.get());
            return Optional.of(team);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Team> updateTeam(Team team) {
        com.upside.upside.data.Team toSave = teamMapper.convertToEntity(team);
        com.upside.upside.data.Team savedTeam = teamRepository.save(toSave);

        if(savedTeam != null ) {
            Team response = teamMapper.convertToDto(savedTeam);
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }
}
