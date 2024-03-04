package com.lcwd.rating.service.service;

import com.lcwd.rating.service.dto.RatingDto;
import com.lcwd.rating.service.entity.Rating;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingDto ratingDto);
    List<Rating> listRating();

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
