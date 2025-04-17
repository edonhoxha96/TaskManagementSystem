package com.edonhoxha.TaskManagementSystem.service.impl;

import com.edonhoxha.TaskManagementSystem.dto.TaskCommentDTO;
import com.edonhoxha.TaskManagementSystem.entity.Task;
import com.edonhoxha.TaskManagementSystem.entity.TaskComment;
import com.edonhoxha.TaskManagementSystem.entity.User;
import com.edonhoxha.TaskManagementSystem.repository.TaskCommentRepository;
import com.edonhoxha.TaskManagementSystem.repository.TaskRepository;
import com.edonhoxha.TaskManagementSystem.repository.UserRepository;
import com.edonhoxha.TaskManagementSystem.service.TaskCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskCommentServiceImpl implements TaskCommentService {

    private final TaskCommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public TaskCommentDTO addComment(TaskCommentDTO dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TaskComment comment = TaskComment.builder()
                .task(task)
                .user(user)
                .content(dto.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        comment = commentRepository.save(comment);
        return toDTO(comment);
    }

    @Override
    public List<TaskCommentDTO> getCommentsByTaskId(Long taskId) {
        return commentRepository.findByTask_Id(taskId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private TaskCommentDTO toDTO(TaskComment comment) {
        return TaskCommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUser().getId())
                .taskId(comment.getTask().getId())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}

