package com.utn.BigCoachNBA.controller.model;

import com.utn.BigCoachNBA.projections.PlayerProjection;
import com.utn.BigCoachNBA.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public List<PlayerProjection> getPlayersByTeam(String team) {
        return playerService.getPlayersByTeam(team);
    }

    public List<PlayerProjection> getPlayersByPosition(String position) {
        return playerService.getPlayersByPosition(position);
    }

    public List<PlayerProjection> getPlayersByAge(Integer age) {
        return playerService.getPlayersByAge(age);
    }

    public List<PlayerProjection> getPlayersByFirstName(String name) {
        return playerService.getPlayersByFirstName(name);
    }

    public List<PlayerProjection> getPlayersByLastName(String lastname) {
        return playerService.getPlayersByLastName(lastname);
    }
}
