package com.lcwd.rating.service.service;

import com.lcwd.rating.service.dto.RatingDto;
import com.lcwd.rating.service.entity.Rating;
import com.lcwd.rating.service.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        String ratingId = UUID.randomUUID().toString();
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        rating.setRatingId(ratingId);
        rating = ratingRepository.save(rating);
        ratingDto = modelMapper.map(rating, RatingDto.class);
        return ratingDto;
    }

    @Override
    public List<Rating> listRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> findByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> findByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
