package com.example.TaskManager.Bacnkend.service;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.dto.TaskRequest;
import com.example.TaskManager.Bacnkend.dto.TaskResponse;
import com.example.TaskManager.Bacnkend.exception.UserNotFoundExceptionHandler;
import com.example.TaskManager.Bacnkend.repo.TaskRepo;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.TaskManager.Bacnkend.Model.ModelUser;
import com.example.TaskManager.Bacnkend.dto.UserRequest;
import com.example.TaskManager.Bacnkend.dto.UserResponse;
import com.example.TaskManager.Bacnkend.repo.UserRepo;

import javax.management.RuntimeErrorException;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TaskRepo taskRepo;


    public UserResponse addUser(UserRequest userRequest){

        // Converts the entity dto to entity (user)
        ModelUser user = mapper.map(userRequest,ModelUser.class);

        // convert the user entity to dto and return it

        ModelUser savedUser = userRepo.save(user);

        return mapper.map(savedUser, UserResponse.class);

    }

    public UserResponse getuserById(int id) {
        ModelUser user = userRepo.findById(id).orElseThrow(()-> new UserNotFoundExceptionHandler("User not found"));
        return mapper.map(user,UserResponse.class);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void createTaskbyUser(int id, TaskRequest taskRequest) {
        ModelUser user = userRepo.findById(id).
                orElseThrow(
                        () -> new RuntimeErrorException(new Error("User Not found"))
                );

        ModelTasks modelTasks = mapper.map(taskRequest,ModelTasks.class);
        modelTasks.setUser(user);
        ModelTasks returnTasks=taskRepo.save(modelTasks);



    }

    public Page<TaskResponse> getTasksByUserid(int userid,Pageable pageable) {
        ModelUser user = userRepo.findById(userid).orElse(new  ModelUser());

        Page<ModelTasks> page = taskRepo.getAllByUser(user,pageable);

        return page.map(modelTasks -> mapper.map(modelTasks,TaskResponse.class));
    }
}
