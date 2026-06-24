package com.example.TaskManager.Bacnkend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.dto.TaskRequest;
import com.example.TaskManager.Bacnkend.dto.TaskResponse;
import com.example.TaskManager.Bacnkend.service.TaskService;



@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("tasks/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void addTasks(@RequestBody TaskRequest taskRequest){
        
        service.addTasks(taskRequest);
    }

    @GetMapping("/hello")
    public String greetings() {
        return "hello!!!!";
    }

    @GetMapping("tasks/show/all")
    public List<ModelTasks> seeallTasks() {
        return service.seeallTasks();
    }
    

    @GetMapping("tasks/show/{id}")
    public ResponseEntity<TaskResponse> getTasks(@PathVariable int id){
        return ResponseEntity.ok(service.getTasks(id));
    }

    @DeleteMapping("tasks/delete/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public void deleteTask(@PathVariable int id){
        service.deleteTask(id);
    }

    
    

    @GetMapping("/tasks")
    public Page<TaskResponse> getpageTasks(Pageable pageable){
        return service.getpageTasks(pageable);
    } 
}
    
    

