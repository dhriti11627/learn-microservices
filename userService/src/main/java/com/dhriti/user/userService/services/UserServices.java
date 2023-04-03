package com.dhriti.user.userService.services;

import com.dhriti.user.userService.entities.User;

import java.util.List;

public interface UserServices {
    User create(User user);
    List<User> readAll();
    User readOne(String userId);
}
