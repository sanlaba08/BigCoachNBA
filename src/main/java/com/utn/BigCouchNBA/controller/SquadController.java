package com.utn.BigCouchNBA.controller;

import com.utn.BigCouchNBA.exceptions.SquadNotExist;
import com.utn.BigCouchNBA.projections.PlayerProjection;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import com.utn.BigCouchNBA.service.PlayerService;
import com.utn.BigCouchNBA.service.SquadService;
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

    public List<SquadStatsProjection> getPlayersStatsSquads() throws SquadNotExist {
        return squadService.getPlayersStatsSquads();
    }
}
