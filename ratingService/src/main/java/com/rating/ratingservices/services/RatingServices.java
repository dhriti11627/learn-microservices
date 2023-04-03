package com.rating.ratingservices.services;

import com.rating.ratingservices.entities.Rating;

import java.util.List;

public interface RatingServices {
    Rating create(Rating rating);
    Rating readOne(String ratingId);
    Rating readByUserId(String userId);
    Rating readByHotelId(String hotelId);
    List<Rating> readAll();
}
