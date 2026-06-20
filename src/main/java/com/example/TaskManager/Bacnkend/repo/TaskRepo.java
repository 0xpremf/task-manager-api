package com.example.TaskManager.Bacnkend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;

@Repository
public interface TaskRepo extends JpaRepository<ModelTasks, Integer>{

}
