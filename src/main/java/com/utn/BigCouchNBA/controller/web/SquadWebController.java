package com.utn.BigCouchNBA.controller.web;

import com.utn.BigCouchNBA.controller.SquadController;
import com.utn.BigCouchNBA.exceptions.SquadNotExist;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/squad")
public class SquadWebController {
    private final SquadController squadController;

    @Autowired
    public SquadWebController(SquadController squadController) {
        this.squadController = squadController;
    }

    @GetMapping("/")
    public ResponseEntity<List<SquadStatsProjection>> getPlayersByTeam() throws SquadNotExist {
        List<SquadStatsProjection> playerStats = squadController.getPlayersStatsSquads();
        if (playerStats.size() > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(playerStats);
        }else{
            throw new SquadNotExist("Squad not exist");
        }
    }
}
