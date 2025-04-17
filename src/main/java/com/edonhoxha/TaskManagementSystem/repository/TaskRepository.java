package com.edonhoxha.TaskManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edonhoxha.TaskManagementSystem.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject_Id(Long projectId);
    List<Task> findByAssignedTo_Id(Long userId);
}

