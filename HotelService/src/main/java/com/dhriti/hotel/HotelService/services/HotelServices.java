package com.dhriti.hotel.HotelService.services;

import com.dhriti.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelServices {
    Hotel create(Hotel hotel);
    Hotel readOne(String hotelId);
    List<Hotel> readAll();
}
