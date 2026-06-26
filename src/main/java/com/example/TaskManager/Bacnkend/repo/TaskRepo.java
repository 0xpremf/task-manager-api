package com.example.TaskManager.Bacnkend.repo;

import com.example.TaskManager.Bacnkend.Model.ModelUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.Bacnkend.Model.ModelTasks;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<ModelTasks, Integer>{

    List<ModelTasks> user(ModelUser user);

    Page<ModelTasks> getAllByUser(ModelUser user, Pageable pageable);
}
