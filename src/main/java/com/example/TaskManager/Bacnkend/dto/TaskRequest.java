package com.example.TaskManager.Bacnkend.dto;

import com.example.TaskManager.Bacnkend.Model.Priority;
import com.example.TaskManager.Bacnkend.Model.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Priority taskPriority=Priority.MEDIUM;

    @NotNull
    @NotEmpty
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status taskStatus=Status.IN_PROGRESS;

    

}
