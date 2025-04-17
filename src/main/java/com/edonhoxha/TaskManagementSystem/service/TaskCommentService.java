package com.edonhoxha.TaskManagementSystem.service;

import com.edonhoxha.TaskManagementSystem.dto.TaskCommentDTO;

import java.util.List;

public interface TaskCommentService {
    TaskCommentDTO addComment(TaskCommentDTO commentDTO);
    List<TaskCommentDTO> getCommentsByTaskId(Long taskId);
}

