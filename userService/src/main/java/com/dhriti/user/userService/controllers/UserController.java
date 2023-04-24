package com.dhriti.user.userService.controllers;

import com.dhriti.user.userService.entities.Rating;
import com.dhriti.user.userService.external.services.RatingService;
import com.dhriti.user.userService.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.dhriti.user.userService.entities.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;

    Logger logger = LoggerFactory.getLogger(UserServices.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userServices.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user1 = userServices.readOne(userId);
        // call rating api from here to get all the ratings done by this user.
//        Rating rating = restTemplate.getForObject("http://localhost:8082/ratings/users/"+userId, Rating.class);
//        logger.info(rating.toString());
        Rating rating = ratingService.getRating(userId);
        user1.setRatings(rating);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userServices.readAll();
        return ResponseEntity.ok(allUsers);

    }
}
