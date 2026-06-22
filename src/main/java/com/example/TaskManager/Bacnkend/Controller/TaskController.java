package com.example.TaskManager.Bacnkend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.service.TaskService;

import jakarta.validation.Valid;



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
    public List<ModelTasks> seeallTasks() {
        return service.seeallTasks();
    }
    

    @GetMapping("/show/{id}")
    public ModelTasks getTasks(@PathVariable int id){
        return service.getTasks(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public void deleteTask(@PathVariable int id){
        service.deleteTask(id);
    }

    
    @PatchMapping("update/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public ResponseEntity <ModelTasks> updateTask(@Valid  @PathVariable int id, 
        @Valid @RequestBody ModelTasks updatedtasks) {
        service.updateTask(id, updatedtasks);
        return ResponseEntity.ok( service.getTasks(id));
    }
    

    @GetMapping("/tasks")
    public Page<ModelTasks> getpageTasks(Pageable pageable){
        return service.getpageTasks(pageable);
    } 
}
    
    

