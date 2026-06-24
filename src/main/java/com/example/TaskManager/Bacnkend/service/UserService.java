package com.example.TaskManager.Bacnkend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.Bacnkend.Model.ModelUser;
import com.example.TaskManager.Bacnkend.dto.UserRequest;
import com.example.TaskManager.Bacnkend.dto.UserResponse;
import com.example.TaskManager.Bacnkend.repo.UserRepo;





@Service
public class UserService {

    @Autowired
    private  UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    public UserResponse addUser(UserRequest userRequest){
        
        // Converts the entity dto to entity (user)
        ModelUser user = mapper.map(userRequest,ModelUser.class);
        
        // convert the user entity to dto and return it

        ModelUser savedUser = userRepo.save(user);

        return mapper.map(savedUser, UserResponse.class);
        
    }

}
