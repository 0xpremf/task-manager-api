package com.example.TaskManager.Bacnkend.Controller;

import com.example.TaskManager.Bacnkend.dto.TaskRequest;
import com.example.TaskManager.Bacnkend.dto.TaskResponse;
import com.example.TaskManager.Bacnkend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManager.Bacnkend.dto.UserRequest;
import com.example.TaskManager.Bacnkend.dto.UserResponse;
import com.example.TaskManager.Bacnkend.service.UserService;




@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponse> getuserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getuserById(id));
    }

    @GetMapping("/{userid}/tasks")
    public Page<TaskResponse> getTasksByUserid(@PathVariable int userid, Pageable pageable) {
        return userService.getTasksByUserid(userid,pageable);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <UserResponse> addUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.addUser(userRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteUser(@PathVariable int id){
        userService. deleteUser(id);
    }

    @PostMapping("/{id}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@PathVariable int id, @RequestBody TaskRequest taskRequest){
        userService.createTaskbyUser(id, taskRequest);
    }

}
