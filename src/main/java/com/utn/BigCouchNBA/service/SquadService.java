package com.utn.BigCouchNBA.service;

import com.utn.BigCouchNBA.projections.PlayerProjection;
import com.utn.BigCouchNBA.projections.SquadPlayerProjection;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import com.utn.BigCouchNBA.repository.PlayerRepository;
import com.utn.BigCouchNBA.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SquadService {
    private final SquadRepository squadRepository;

    @Autowired
    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public List<SquadStatsProjection> getPlayersStatsSquads(String dni) {
        return squadRepository.getPlayersStatsSquads(dni);
    }

    public List<SquadPlayerProjection> getPlayersSquads(String dni) {
        return squadRepository.getPlayersSquads(dni);
    }
}
