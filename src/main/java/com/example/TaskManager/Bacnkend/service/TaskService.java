package com.example.TaskManager.Bacnkend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
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
        .orElseThrow(()-> new RuntimeException("Task_ID not Found!!"));
    }

}
