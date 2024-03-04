package com.lcwd.rating.service.controller;

import com.lcwd.rating.service.dto.RatingDto;
import com.lcwd.rating.service.entity.Rating;
import com.lcwd.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto){
        return new ResponseEntity<>(ratingService.createRating(ratingDto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public List<Rating> findAllRating(){
        return ratingService.listRating();
    }

    @GetMapping("/findByUserId/{userId}")
    public List<Rating> findByUserId(@PathVariable String userId){
        return ratingService.findByUserId(userId);
    }

    @GetMapping("/findByHotelId/{hotelId}")
    public List<Rating> findByHotelId(@PathVariable String hotelId){
        return ratingService.findByHotelId(hotelId);
    }

}
