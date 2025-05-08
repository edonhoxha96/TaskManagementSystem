package com.edonhoxha.TaskManagementSystem.dto;

import com.edonhoxha.TaskManagementSystem.entity.Role;
import lombok.Data;

@Data
public class RoleUpdateDTO {
    private Long userId;
    private Role newRole;
}

