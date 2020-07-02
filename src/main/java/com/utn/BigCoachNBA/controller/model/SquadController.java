package com.utn.BigCoachNBA.controller.model;

import com.utn.BigCoachNBA.exceptions.SquadNotExist;
import com.utn.BigCoachNBA.exceptions.ValidationException;
import com.utn.BigCoachNBA.model.Squad;
import com.utn.BigCoachNBA.projections.SquadPlayerProjection;
import com.utn.BigCoachNBA.projections.SquadStatsProjection;
import com.utn.BigCoachNBA.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SquadController {
    private final SquadService squadService;

    @Autowired
    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    public void addPlayerById(Integer id, String dni) throws ValidationException {
        if(id != null){
            squadService.addPlayerById(id, dni);
        }else{
            throw new ValidationException();
        }
    }

    public List<SquadStatsProjection> getPlayersStatsSquads(String dni) throws SquadNotExist {
        return squadService.getPlayersStatsSquads(dni);
    }

    public List<SquadPlayerProjection> getPlayersSquads(String dni) throws SquadNotExist {
        return squadService.getPlayersSquads(dni);
    }

    public void updatePlayerById(Integer idPlayerOld, Integer idPlayerNew, String dni) throws ValidationException {
        if(idPlayerOld != null || idPlayerNew != null){
            squadService.updatePlayerById(idPlayerOld, idPlayerNew, dni);
        }else{
            throw new ValidationException();
        }
    }
}
