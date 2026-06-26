package com.example.TaskManager.Bacnkend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;

@Data
@Getter
@Setter
public class UserRequest {

    @NotNull
    @NotBlank(message = " username cannot be blank")
    @NotEmpty
    private String username;
    


}
