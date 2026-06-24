package com.example.TaskManager.Bacnkend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRequest {
    
    @NotBlank(message = " username cannot be blank")
    private String username;
    


}
