package com.edonhoxha.TaskManagementSystem.service;

import com.edonhoxha.TaskManagementSystem.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO getProjectById(Long id);
    List<ProjectDTO> getAllProjects();
    List<ProjectDTO> getProjectsByUserId(Long userId);
}
