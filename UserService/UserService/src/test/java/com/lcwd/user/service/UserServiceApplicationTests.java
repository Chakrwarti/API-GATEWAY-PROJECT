package com.lcwd.user.service;

import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.external.service.RatingService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating = Rating.builder().ratingId("10").userId("").hotelId("").rating(3).feedback("this is good").build();
		Rating saveRating = ratingService.createRating(rating);
		System.out.println("this rating is creating");
	}

}
