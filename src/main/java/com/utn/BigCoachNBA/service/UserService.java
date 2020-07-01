package com.utn.BigCoachNBA.service;


import com.utn.BigCoachNBA.dto.UserDto;
import com.utn.BigCoachNBA.exceptions.UserNotFoundException;
import com.utn.BigCoachNBA.model.User;
import com.utn.BigCoachNBA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String dni, String password) throws UserNotFoundException {
        User user = userRepository.getByUsername(dni, password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNotFoundException());
    }

    public void createUser(UserDto user){
        userRepository.createUser(user.getFirstName(), user.getLastName(), user.getDni(), user.getPwd());
    }


    public void updateUser(UserDto user){
     userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getDni(), user.getPwd());
    }

    public void deleteUser(String dni) {
        userRepository.deleteUser(dni);
    }
}
