package com.utn.BigCouchNBA.controller.model;


import com.utn.BigCouchNBA.dto.UserDto;
import com.utn.BigCouchNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCouchNBA.exceptions.UserNotFoundException;
import com.utn.BigCouchNBA.model.User;
import com.utn.BigCouchNBA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.ValidationException;
import java.util.List;

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
