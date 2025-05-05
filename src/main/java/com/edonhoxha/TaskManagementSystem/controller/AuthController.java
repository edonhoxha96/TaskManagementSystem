package com.edonhoxha.TaskManagementSystem.controller;

import com.edonhoxha.TaskManagementSystem.dto.AuthRequest;
import com.edonhoxha.TaskManagementSystem.dto.AuthResponse;
import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;
import com.edonhoxha.TaskManagementSystem.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        System.out.println("Login endpoint hit");
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserRegistrationDTO request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }
}
