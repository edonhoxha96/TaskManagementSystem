package com.edonhoxha.TaskManagementSystem.service;

import java.util.List;

import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;
import com.edonhoxha.TaskManagementSystem.entity.Role;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO createUser(UserRegistrationDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUserRole(Long userId, Role newRole);
}

