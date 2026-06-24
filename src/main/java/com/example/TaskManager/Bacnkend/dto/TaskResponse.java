package com.example.TaskManager.Bacnkend.dto;

import java.time.LocalDateTime;

import com.example.TaskManager.Bacnkend.Model.Priority;
import com.example.TaskManager.Bacnkend.Model.Status;

import lombok.Data;
import lombok.Setter;



@Data
@Setter
public class TaskResponse {
     private Integer id; 
    private String title;
    private String description;
    private LocalDateTime dateCreated;
    private Priority taskPriority;
    private Status taskStatus;

}
