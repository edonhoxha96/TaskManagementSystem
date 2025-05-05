package com.edonhoxha.TaskManagementSystem.service;

import com.edonhoxha.TaskManagementSystem.dto.AuthRequest;
import com.edonhoxha.TaskManagementSystem.dto.AuthResponse;
import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    UserDTO register(UserRegistrationDTO request);
}
