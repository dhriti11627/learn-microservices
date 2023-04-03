package com.rating.ratingservices.impl;

import com.rating.ratingservices.Repositories.RatingRepository;
import com.rating.ratingservices.entities.Rating;
import com.rating.ratingservices.exceptions.ResourceNotFound;
import com.rating.ratingservices.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServicesImpl implements RatingServices {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating readOne(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFound());
    }

    @Override
    public Rating readByUserId(String userId) {
        return ratingRepository.findRatingByUserId(userId);
    }

    @Override
    public Rating readByHotelId(String hotelId) {
        return ratingRepository.findRatingByHotelId(hotelId);
    }

    @Override
    public List<Rating> readAll() {
        return ratingRepository.findAll();
    }
}
