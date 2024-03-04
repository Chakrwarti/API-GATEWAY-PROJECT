package com.lcwd.user.service.service;

import com.lcwd.user.service.dto.UserDto;
import com.lcwd.user.service.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<User> listAllUser();

    void deleteById(String userId);

    User findById(String userId);
}
