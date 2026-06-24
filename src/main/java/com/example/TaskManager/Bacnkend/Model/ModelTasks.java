package com.example.TaskManager.Bacnkend.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasks")
public class ModelTasks {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; //because Integer can hold null value 
    
    
    @Column(name="title")
   
    private String title;

    @Column(name="description")
   
    private String description;
    
    @Column(name="date_created",updatable=false)
    @CreationTimestamp
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDateTime dateCreated;

    @Column(name="Priority")
    @Enumerated(EnumType.STRING)
    
    private Priority taskPriority=Priority.MEDIUM;

    @Column(name="Status")
    @Enumerated(EnumType.STRING)
    private Status taskStatus=Status.IN_PROGRESS;



}


