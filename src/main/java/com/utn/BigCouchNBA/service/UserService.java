package com.utn.BigCouchNBA.service;


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

    public User login(String username, String password) throws UserNotFoundException {
        User user = userRepository.getByUsername(username, password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNotFoundException());
    }

    public User createUser(User user) throws UserAlreadyExistsException {
        return userRepository.save(user);
    }


    public void removeUser(User user) throws UserNotFoundException {
        userRepository.delete(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
     return userRepository.save(user);
    }

    public User getUser(Integer userId){
        return userRepository.getOne(userId);
    }

}
