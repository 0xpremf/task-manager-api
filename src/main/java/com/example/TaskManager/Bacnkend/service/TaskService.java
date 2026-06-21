package com.example.TaskManager.Bacnkend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.exception.TaskNotFoundException;
import com.example.TaskManager.Bacnkend.repo.TaskRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    public void addTasks(ModelTasks tasks){
        repo.save(tasks);
    }

    public List<ModelTasks> seeallTasks(){
        return repo.findAll();
    }

    
    public ModelTasks getTasks(int id){
        return repo.findById(id)
        .orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
    }


    public void deleteTask(int id){
        repo.deleteById(id);
    }

    public ModelTasks  updateTask(@PathVariable int id, @RequestBody ModelTasks updateTasks){
        ModelTasks existingtask = repo.findById(id).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not Found"));
        
        if(updateTasks.getDescription()!=null){
            existingtask.setDescription(updateTasks.getDescription());
        }
        if(updateTasks.getTaskPriority()!=null){
            existingtask.setTaskPriority(updateTasks.getTaskPriority());
        }
        if(updateTasks.getTaskStatus()!=null){
            existingtask.setTaskStatus(updateTasks.getTaskStatus());
        }
        else{
            return new ModelTasks();
        }
            
        
        
        return repo.save(existingtask);

    }
}
