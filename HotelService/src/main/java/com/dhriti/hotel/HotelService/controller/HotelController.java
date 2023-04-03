package com.dhriti.hotel.HotelService.controller;

import com.dhriti.hotel.HotelService.entities.Hotel;
import com.dhriti.hotel.HotelService.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelServices hotelServices;
    @PostMapping
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelServices.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getOne(@PathVariable String hotelId){
        Hotel hotel1 = hotelServices.readOne(hotelId);
        return ResponseEntity.ok(hotel1);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelServices.readAll();
        return ResponseEntity.ok(hotels);
    }

}
