package com.utn.BigCouchNBA.service;


import com.utn.BigCouchNBA.dto.UserDto;
import com.utn.BigCouchNBA.exceptions.UserAlreadyExistsException;
import com.utn.BigCouchNBA.exceptions.UserNotFoundException;
import com.utn.BigCouchNBA.model.User;
import com.utn.BigCouchNBA.repository.UserRepository;
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
