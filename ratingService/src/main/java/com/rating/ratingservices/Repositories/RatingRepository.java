package com.rating.ratingservices.Repositories;

import com.rating.ratingservices.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,String> {
    Rating findRatingByHotelId(String hotelId);
    Rating findRatingByUserId(String userId);
}
