package com.edonhoxha.TaskManagementSystem.dto;

import com.edonhoxha.TaskManagementSystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private Role role;
}

