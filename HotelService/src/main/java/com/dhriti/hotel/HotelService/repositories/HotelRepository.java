package com.dhriti.hotel.HotelService.repositories;

import com.dhriti.hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository <Hotel,String>{
}
