package com.edonhoxha.TaskManagementSystem.service;

import java.util.List;

import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO createUser(UserRegistrationDTO userDTO);
    List<UserDTO> getAllUsers();
}

