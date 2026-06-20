package com.example.TaskManager.Bacnkend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.service.TaskService;


@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void addTasks(@RequestBody ModelTasks tasks){
        
        service.addTasks(tasks);
    }

    @GetMapping("/hello")
    public String greetings() {
        return "hello!!!!";
    }

    @GetMapping("/show/all")
    public List<ModelTasks> getMethodName() {
        return service.seeallTasks();
    }
    

    @GetMapping("/show/{id}")
    public ModelTasks getTasks(@PathVariable int id){
        return service.getTasks(id);
    }


    
}   
