package com.utn.BigCouchNBA.controller.web;

import com.utn.BigCouchNBA.controller.model.PlayerController;
import com.utn.BigCouchNBA.exceptions.TeamNotExistException;
import com.utn.BigCouchNBA.projections.PlayerProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/player")
public class PlayerWebController {
    private final PlayerController playerController;

    @Autowired
    public PlayerWebController(PlayerController playerController) {
        this.playerController = playerController;
    }

    @GetMapping("/team")
    public ResponseEntity<List<PlayerProjection>> getPlayersByTeam(@RequestParam String name) throws TeamNotExistException{
        List<PlayerProjection> players = playerController.getPlayersByTeam(name);
        if (players.size() > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(players);
        }else{
            throw new TeamNotExistException("Team not exist.");
        }
    }

}
