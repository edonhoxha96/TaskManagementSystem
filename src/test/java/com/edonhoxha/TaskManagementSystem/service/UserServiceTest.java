package com.edonhoxha.TaskManagementSystem.service;

import com.edonhoxha.TaskManagementSystem.dto.UserDTO;
import com.edonhoxha.TaskManagementSystem.entity.Role;
import com.edonhoxha.TaskManagementSystem.entity.User;
import com.edonhoxha.TaskManagementSystem.repository.UserRepository;
import com.edonhoxha.TaskManagementSystem.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetUserById() {
        User user = User.builder()
                .id(1L)
                .username("john")
                .email("john@example.com")
                .role(Role.MEMBER)
                .password("encodedpass")
                .build();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserById(1L);

        assertEquals("john", result.getUsername());
        assertEquals("john@example.com", result.getEmail());
    }
}

