package com.rating.ratingservices.Contollers;

import com.rating.ratingservices.entities.Hotel;
import com.rating.ratingservices.entities.Rating;
import com.rating.ratingservices.external.services.HotelService;
import com.rating.ratingservices.services.RatingServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingController {

    @Autowired
    private RatingServices ratingServices;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
     private HotelService hotelService ;
    Logger logger = LoggerFactory.getLogger(RatingServices.class);
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingServices.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
        Rating rating = ratingServices.readOne(ratingId);
        return ResponseEntity.ok(rating);
    }



    @GetMapping("/users/{userId}")
    public ResponseEntity<Rating> getRatingByUserId(@PathVariable String userId){
        Rating rating1 = ratingServices.readByUserId(userId);
//        Hotel hotel = restTemplate.getForObject("http://localhost:8080/hotels/"+rating1.getHotelId(),Hotel.class);
//       logger.info(String.valueOf(hotel));
        Hotel hotel = hotelService.getHotel(rating1.getHotelId());
        rating1.setHotel(hotel);
        return ResponseEntity.ok(rating1);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelId){
        Rating rating1 = ratingServices.readByHotelId(hotelId);
        return ResponseEntity.ok(rating1);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        List<Rating> ratings = ratingServices.readAll();
        return ResponseEntity.ok(ratings);
    }
}
