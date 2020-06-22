package com.utn.BigCouchNBA.controller;


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

    public User login(String username, String password) throws UserNotFoundException, ValidationException {
        if ((username != null) && (password != null)) {
            return userService.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }


    public User getUserById(Integer userId) {
        return userService.getUser(userId);
    }


    public User createUser(User user) throws UserAlreadyExistsException {
        return userService.createUser(user);
    }

    public void removeUser(User user) throws UserNotFoundException {
        userService.removeUser(user);
    }

    public void removeUsers(List<User> userList) throws UserNotFoundException {
        for (User u : userList) {
            userService.removeUser(u);
        }
    }


    public void updateUser(User user) throws UserNotFoundException {
        userService.updateUser(user);
    }


}
