package com.edonhoxha.TaskManagementSystem.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCommentDTO {
    private Long id;
    private String content;
    private Long userId;
    private Long taskId;
    private LocalDateTime createdAt;
}

