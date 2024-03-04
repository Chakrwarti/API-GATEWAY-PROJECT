package com.lcwd.user.service.service;

import com.lcwd.user.service.dto.UserDto;
import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.external.service.HotelService;
import com.lcwd.user.service.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService  hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        User user = modelMapper.map(userDto, User.class);
        user.setUserId(userId);
        user = userRepository.save(user);
        userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id not Present"+ userId));

        //this first to find user with rating
//        ArrayList<Rating> ratingOfUser = restTemplate.getForObject("http://localhost:8083/api/rating/findByUserId/"+user.getUserId(), ArrayList.class);
//        logger.info("{} ", ratingOfUser);
//        user.setRatings(ratingOfUser);

        //now find user with rating and hotel

        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/rating/findByUserId/"+user.getUserId(), Rating[].class);
        List<Rating> ratings =Arrays.stream(ratingOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //if i am not using feign client
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/"+ rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

            //use feign client
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
