package com.example.TaskManager.Bacnkend.service;

import java.util.List;

import com.example.TaskManager.Bacnkend.Model.ModelUser;
import com.example.TaskManager.Bacnkend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;
import com.example.TaskManager.Bacnkend.dto.TaskRequest;
import com.example.TaskManager.Bacnkend.dto.TaskResponse;
import com.example.TaskManager.Bacnkend.exception.TaskNotFoundException;
import com.example.TaskManager.Bacnkend.repo.TaskRepo;

import javax.management.RuntimeErrorException;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;





    public void addTasks(TaskRequest taskRequest){
        ModelTasks modelTasks=new ModelTasks();    
        modelTasks.setTitle(taskRequest.getTitle());
        modelTasks.setDescription(taskRequest.getDescription());
        repo.save(modelTasks);
    }

    public List<ModelTasks> seeallTasks(){
        return repo.findAll();
    }

    
    public TaskResponse getTasks(int id){
        
        
        ModelTasks modeltasks=repo.findById(id).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
        return convEntitytoResponse(modeltasks);
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


    public Page<TaskResponse> getpageTasks(Pageable pageable){
        Page<ModelTasks> page = repo.findAll(pageable);
       return page.map(this::convEntitytoResponse);
    }



    public TaskResponse convEntitytoResponse(ModelTasks tasks){
        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setTitle(tasks.getTitle());
        taskResponse.setDateCreated(tasks.getDateCreated());
        taskResponse.setDescription(tasks.getDescription());
        taskResponse.setId(tasks.getId());
        taskResponse.setTaskPriority(tasks.getTaskPriority());
        taskResponse.setTaskStatus(tasks.getTaskStatus());
        return taskResponse;
    }



}
