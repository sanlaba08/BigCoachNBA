package com.utn.BigCoachNBA.controller.model;

import com.utn.BigCoachNBA.dto.LoginDto;
import com.utn.BigCoachNBA.exceptions.InvalidLoginException;
import com.utn.BigCoachNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCoachNBA.exceptions.UserNotFoundException;
import com.utn.BigCoachNBA.model.User;
import com.utn.BigCoachNBA.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.bind.ValidationException;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class LoginController {

    private UserController userController;
    private SessionManager sessionManager;

    @Autowired
    public LoginController(UserController userController, SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) throws InvalidLoginException, ValidationException {
        String token = null;
        ResponseEntity response;
        try {
            User user = userController.login(loginDto.getDni(), loginDto.getPassword());
            token = sessionManager.createSession(user);
            response = ResponseEntity.ok().headers(createHeaders(token)).build();
        } catch (UserNotFoundException e) {
            throw new InvalidLoginException(e);
        }
        return response;
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {
        sessionManager.removeSession(token);
        return ResponseEntity.ok().build();
    }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }

    private URI getLocation(User user) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getIdUser())
                .toUri();
    }

}
