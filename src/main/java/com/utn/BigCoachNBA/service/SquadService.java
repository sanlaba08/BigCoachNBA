package com.utn.BigCoachNBA.service;

import com.utn.BigCoachNBA.model.Squad;
import com.utn.BigCoachNBA.projections.SquadPlayerProjection;
import com.utn.BigCoachNBA.projections.SquadStatsProjection;
import com.utn.BigCoachNBA.repository.SquadRepository;
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


    public void addPlayerById(Integer id, String dni){
        squadRepository.addPlayerById(id, dni);
    }

    public List<SquadStatsProjection> getPlayersStatsSquads(String dni) {
        return squadRepository.getPlayersStatsSquads(dni);
    }

    public List<SquadPlayerProjection> getPlayersSquads(String dni) {
        return squadRepository.getPlayersSquads(dni);
    }

    public void updatePlayerById(Integer idPlayerOld, Integer idPlayerNew, String dni) {
        squadRepository.updatePlayerById(idPlayerOld, idPlayerNew,dni);
    }
}
