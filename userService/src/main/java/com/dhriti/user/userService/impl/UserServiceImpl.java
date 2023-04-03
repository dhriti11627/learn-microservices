package com.dhriti.user.userService.impl;

import com.dhriti.user.userService.entities.User;
import com.dhriti.user.userService.exceptions.ResourceNotFoundException;
import com.dhriti.user.userService.repositories.UserRepository;
import com.dhriti.user.userService.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User user) {
        String id =  UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }


    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }


    @Override
    public User readOne(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("The User With Given Id doesn't exist" + userId));
    }
}
