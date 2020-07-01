package com.utn.BigCouchNBA.controller.admin;

import com.utn.BigCouchNBA.controller.model.PlayerController;
import com.utn.BigCouchNBA.controller.model.UserController;
import com.utn.BigCouchNBA.dto.UserDto;
import com.utn.BigCouchNBA.exceptions.SquadNotExist;
import com.utn.BigCouchNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCouchNBA.exceptions.UserNotFoundException;
import com.utn.BigCouchNBA.model.User;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import com.utn.BigCouchNBA.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final UserController userController;

    @Autowired
    public AdminController(UserController userController) {
        this.userController = userController;
    }

    @DeleteMapping("/")
    public ResponseEntity deleteUser(@RequestParam String dni) {
        userController.deleteUser(dni);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserDto userDto ) throws UserAlreadyExistsException {
        userController.createUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity updateUser(@RequestBody UserDto userDto ) throws UserNotFoundException {
        userController.updateUser(userDto);
        return ResponseEntity.ok().build();
    }
}
