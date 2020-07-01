package com.utn.BigCoachNBA.controller.admin;

import com.utn.BigCoachNBA.controller.model.UserController;
import com.utn.BigCoachNBA.dto.UserDto;
import com.utn.BigCoachNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCoachNBA.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
