package com.example.TaskManager.Bacnkend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserResponse {
    
    private int id;
    private String username;
    private Date dateCreatedAt;
}
