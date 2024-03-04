package com.lcwd.user.service.external.service;

import com.lcwd.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/api/rating/save")
    Rating createRating(Rating rating);
}
