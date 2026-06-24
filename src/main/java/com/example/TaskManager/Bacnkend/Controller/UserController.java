package com.example.TaskManager.Bacnkend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.Bacnkend.dto.UserRequest;
import com.example.TaskManager.Bacnkend.dto.UserResponse;
import com.example.TaskManager.Bacnkend.service.UserService;




@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);    
    }

}
