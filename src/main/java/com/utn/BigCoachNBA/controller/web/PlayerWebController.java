package com.utn.BigCoachNBA.controller.web;

import com.utn.BigCoachNBA.controller.model.PlayerController;
import com.utn.BigCoachNBA.exceptions.TeamNotExistException;
import com.utn.BigCoachNBA.projections.PlayerProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/web/player")
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
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }else{
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }
    }

    @GetMapping("/position/")
    public ResponseEntity<List<PlayerProjection>> getPlayersByPosition(@RequestParam String position){
        List<PlayerProjection> players = playerController.getPlayersByPosition(position);
        if (players.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<PlayerProjection>> getPlayersByAge(@PathVariable Integer age){
        List<PlayerProjection> players = playerController.getPlayersByAge(age);
        if (players.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }
    }

    @GetMapping("/firstname/")
    public ResponseEntity<List<PlayerProjection>> getPlayersByFirstName(@RequestParam String name){
        List<PlayerProjection> players = playerController.getPlayersByFirstName(name);
        if (players.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }
    }

    @GetMapping("/lastname/")
    public ResponseEntity<List<PlayerProjection>> getPlayersByLastName(@RequestParam String lastname){
        List<PlayerProjection> players = playerController.getPlayersByLastName(lastname);
        if (players.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(players);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }
    }


}
