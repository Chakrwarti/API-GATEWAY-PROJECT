package com.lcwd.hotel.service.service;

import com.lcwd.hotel.service.dto.HotelDtos;
import com.lcwd.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {

    HotelDtos createHotel(HotelDtos hotelDto);

    Hotel findByHotelId(String hotelId);

}
