package com.edonhoxha.TaskManagementSystem.service.impl;

import com.edonhoxha.TaskManagementSystem.dto.AuthRequest;
import com.edonhoxha.TaskManagementSystem.dto.AuthResponse;
import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;
import com.edonhoxha.TaskManagementSystem.entity.User;
import com.edonhoxha.TaskManagementSystem.repository.UserRepository;
import com.edonhoxha.TaskManagementSystem.security.JwtUtil;
import com.edonhoxha.TaskManagementSystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                )
        );

        return new AuthResponse(token);
    }

    @Override
    public UserDTO register(UserRegistrationDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role("MEMBER")
                .build();

        user = userRepository.save(user);

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}

