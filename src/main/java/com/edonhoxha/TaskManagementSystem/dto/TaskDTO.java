package com.edonhoxha.TaskManagementSystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDate dueDate;
    private Long assignedTo; // user ID
    private Long projectId;
}

