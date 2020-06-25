package com.utn.BigCouchNBA.controller.web;

import com.utn.BigCouchNBA.controller.model.SquadController;
import com.utn.BigCouchNBA.exceptions.SquadNotExist;
import com.utn.BigCouchNBA.model.User;
import com.utn.BigCouchNBA.projections.SquadPlayerProjection;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import com.utn.BigCouchNBA.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/web/squad")
public class SquadWebController {
    private final SquadController squadController;
    private final SessionManager sessionManager;


    public SquadWebController(SquadController squadController, SessionManager sessionManager) {
        this.squadController = squadController;
        this.sessionManager = sessionManager;
    }

    @GetMapping("/stats")
    public ResponseEntity<List<SquadStatsProjection>> getPlayersByTeam(@RequestHeader("Authorization") String sessionToken) throws SquadNotExist {
        User session = sessionManager.getCurrentUser(sessionToken);
        List<SquadStatsProjection> playerStats = squadController.getPlayersStatsSquads(session.getDni());
        if (playerStats.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(playerStats);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(playerStats);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<SquadPlayerProjection>> getPlayersSquads(@RequestHeader("Authorization") String sessionToken) throws SquadNotExist {
        User session = sessionManager.getCurrentUser(sessionToken);
        List<SquadPlayerProjection> playerSquad = squadController.getPlayersSquads(session.getDni());
        if (playerSquad.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(playerSquad);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(playerSquad);
        }
    }
}
