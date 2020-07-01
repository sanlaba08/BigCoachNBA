package com.utn.BigCoachNBA.service;

import com.utn.BigCoachNBA.projections.PlayerProjection;
import com.utn.BigCoachNBA.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerProjection> getPlayersByTeam(String team) {
        return playerRepository.getPlayersByTeam(team);
    }

    public List<PlayerProjection> getPlayersByPosition(String position) {
        return playerRepository.getPlayersByPosition(position);
    }
}
