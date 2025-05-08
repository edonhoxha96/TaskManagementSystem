package com.edonhoxha.TaskManagementSystem.controller;

import com.edonhoxha.TaskManagementSystem.dto.RoleUpdateDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;
import com.edonhoxha.TaskManagementSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRegistrationDTO userDTO) {
        UserDTO created = userService.createUser(userDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PatchMapping("/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> updateUserRole(@RequestBody RoleUpdateDTO dto) {
        return ResponseEntity.ok(userService.updateUserRole(dto.getUserId(), dto.getNewRole()));
    }
}
