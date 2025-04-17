package com.edonhoxha.TaskManagementSystem.service;

import com.edonhoxha.TaskManagementSystem.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getTasksByProjectId(Long projectId);
    List<TaskDTO> getTasksByUserId(Long userId);
    TaskDTO updateTaskStatus(Long taskId, String status);
}
