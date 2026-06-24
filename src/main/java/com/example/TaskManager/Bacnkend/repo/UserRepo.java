package com.example.TaskManager.Bacnkend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.Bacnkend.Model.ModelUser;

@Repository
public interface UserRepo extends JpaRepository<ModelUser,Integer>{

}
