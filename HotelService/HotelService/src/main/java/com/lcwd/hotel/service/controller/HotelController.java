package com.lcwd.hotel.service.controller;

import com.lcwd.hotel.service.dto.HotelDtos;
import com.lcwd.hotel.service.entity.Hotel;
import com.lcwd.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<HotelDtos> createHotel(@RequestBody HotelDtos hotelDtos){
        HotelDtos dtos = hotelService.createHotel(hotelDtos);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public Hotel findBYId(@PathVariable String hotelId){
        return hotelService.findByHotelId(hotelId);
    }
}
