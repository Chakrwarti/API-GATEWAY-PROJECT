package com.lcwd.hotel.service.service;

import com.lcwd.hotel.service.dto.HotelDtos;
import com.lcwd.hotel.service.entity.Hotel;
import com.lcwd.hotel.service.exception.ResourceNotFoundException;
import com.lcwd.hotel.service.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDtos createHotel(HotelDtos hotelDto) {
        String hotelId = UUID.randomUUID().toString();
        Hotel hotel =modelMapper.map(hotelDto, Hotel.class);
        hotel.setHotelId(hotelId);
        hotel = hotelRepository.save(hotel);
        hotelDto = modelMapper.map(hotel, HotelDtos.class);
        return hotelDto;
    }

    @Override
    public Hotel findByHotelId(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("this id not exist = "+hotelId));
    }
}
