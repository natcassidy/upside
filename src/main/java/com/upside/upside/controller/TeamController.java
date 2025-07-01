package com.upside.upside.controller;

import com.upside.upside.controller.dto.AddPlayerRequest;
import com.upside.upside.service.TeamService;
import com.upside.upside.service.dto.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Integer id) {
        Optional<Team> team = teamService.getTeam(id);

        if(team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PutMapping("/addPlayers")
//    public ResponseEntity<Team> addPlayer(@RequestBody AddPlayerRequest addPlayerRequest) {
//
//        return null;
//    }
}
