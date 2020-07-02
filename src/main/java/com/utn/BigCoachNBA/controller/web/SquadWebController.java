package com.utn.BigCoachNBA.controller.web;

import com.utn.BigCoachNBA.controller.model.SquadController;
import com.utn.BigCoachNBA.exceptions.SquadNotExist;
import com.utn.BigCoachNBA.exceptions.ValidationException;
import com.utn.BigCoachNBA.model.Squad;
import com.utn.BigCoachNBA.model.User;
import com.utn.BigCoachNBA.projections.SquadPlayerProjection;
import com.utn.BigCoachNBA.projections.SquadStatsProjection;
import com.utn.BigCoachNBA.session.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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


    @PostMapping("/{idPlayer}")
    public ResponseEntity addPlayerById( @RequestHeader("Authorization") String sessionToken, @PathVariable("idPlayer") Integer idPlayer ) throws URISyntaxException, ValidationException {
        try{
            User session = sessionManager.getCurrentUser(sessionToken);
            squadController.addPlayerById(idPlayer, session.getDni());
            return ResponseEntity.created(new URI("localhost:8080/api/web/squad/"+idPlayer)).build();
        } catch(JpaSystemException e){
            throw new ValidationException(e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("/{idPlayerOld}/{idPlayerNew}")
    public ResponseEntity updatePlayerById( @RequestHeader("Authorization") String sessionToken, @PathVariable("idPlayerOld") Integer idPlayerOld,  @PathVariable("idPlayerNew") Integer idPlayerNew ) throws URISyntaxException, ValidationException {
        try{
            User session = sessionManager.getCurrentUser(sessionToken);
            squadController.updatePlayerById(idPlayerOld,idPlayerNew, session.getDni());
            return ResponseEntity.accepted().build();
        } catch(JpaSystemException e){
            throw new ValidationException(e.getCause().getCause().getMessage());
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<List<SquadStatsProjection>> getPlayersStatsSquads(@RequestHeader("Authorization") String sessionToken) throws SquadNotExist {
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
