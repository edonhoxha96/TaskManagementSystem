package com.edonhoxha.TaskManagementSystem.controller;

import com.edonhoxha.TaskManagementSystem.dto.TaskCommentDTO;
import com.edonhoxha.TaskManagementSystem.service.TaskCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class TaskCommentController {

    private final TaskCommentService taskCommentService;

    @PostMapping
    public ResponseEntity<TaskCommentDTO> addComment(@RequestBody @Valid TaskCommentDTO commentDTO) {
        TaskCommentDTO created = taskCommentService.addComment(commentDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/by-task/{taskId}")
    public ResponseEntity<List<TaskCommentDTO>> getCommentsByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskCommentService.getCommentsByTaskId(taskId));
    }
}

