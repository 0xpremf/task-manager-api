package com.example.TaskManager.Bacnkend.exception;





public class UserNotFoundExceptionHandler extends RuntimeException{
    public UserNotFoundExceptionHandler(String message){
        super(message);
    }
}
