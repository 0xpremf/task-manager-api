package com.example.TaskManager.Bacnkend.dto;

import com.example.TaskManager.Bacnkend.Model.Priority;
import com.example.TaskManager.Bacnkend.Model.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskRequest {
    @NotBlank
    private String title;
   
    @NotBlank
    private String description;
    
    @Enumerated(EnumType.STRING)
    private Priority tasPriority=Priority.LOW;
    
    @Enumerated(EnumType.STRING)
    private Status taskStatus=Status.IN_PROGRESS;

    

}
