package com.lcwd.user.service.controler;

import com.lcwd.user.service.dto.UserDto;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.listAllUser();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("this is deleted", HttpStatus.OK);
    }
    //http://localhost:8081/api/users/
    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable String userId){
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }
}
