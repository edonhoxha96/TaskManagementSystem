package com.edonhoxha.TaskManagementSystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.edonhoxha.TaskManagementSystem.entity.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.dto.UserRegistrationDTO;
import com.edonhoxha.TaskManagementSystem.entity.User;
import com.edonhoxha.TaskManagementSystem.repository.UserRepository;
import com.edonhoxha.TaskManagementSystem.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		return toDTO(user);
	}
	
	@Override
	public UserDTO createUser(UserRegistrationDTO dto) {
		User user = User.builder()
				.username(dto.getUsername())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.role(dto.getRole())
				.build();
		user = userRepository.save(user);
		return toDTO(user);
	}
	
	@Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

	@Override
	public UserDTO updateUserRole(Long userId, Role newRole) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));

		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		if (user.getUsername().equals(currentUsername)) {
			throw new IllegalArgumentException("You cannot change your own role.");
		}

		if (user.getRole() == newRole) {
			throw new IllegalArgumentException("User already has role " + newRole);
		}

		user.setRole(newRole);
		userRepository.save(user);

		return UserDTO.builder()
				.id(user.getId())
				.username(user.getUsername())
				.email(user.getEmail())
				.role(user.getRole())
				.build();
	}

    private UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
