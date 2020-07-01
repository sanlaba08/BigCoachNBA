package com.utn.BigCoachNBA.controller.model;


import com.utn.BigCoachNBA.dto.UserDto;
import com.utn.BigCoachNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCoachNBA.exceptions.UserNotFoundException;
import com.utn.BigCoachNBA.model.User;
import com.utn.BigCoachNBA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.ValidationException;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User login(String dni, String password) throws UserNotFoundException, ValidationException {
        if ((dni != null) && (password != null)) {
            return userService.login(dni, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

    public void createUser(UserDto user) throws UserAlreadyExistsException {
        userService.createUser(user);
    }

    public void updateUser(UserDto user) throws UserNotFoundException {
        userService.updateUser(user);
    }

    public void deleteUser(String dni) {
        userService.deleteUser(dni);
    }
}
