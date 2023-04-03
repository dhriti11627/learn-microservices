package com.dhriti.hotel.HotelService.impl;

import com.dhriti.hotel.HotelService.entities.Hotel;
import com.dhriti.hotel.HotelService.exceptions.ResourceNotFound;
import com.dhriti.hotel.HotelService.repositories.HotelRepository;
import com.dhriti.hotel.HotelService.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServicesImpl implements HotelServices {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
       return hotelRepository.save(hotel);
    }

    @Override
    public Hotel readOne(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFound());
    }

    @Override
    public List<Hotel> readAll() {
        return hotelRepository.findAll();
    }
}
