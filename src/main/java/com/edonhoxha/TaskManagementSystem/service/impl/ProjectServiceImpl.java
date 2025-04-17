package com.edonhoxha.TaskManagementSystem.service.impl;

import com.edonhoxha.TaskManagementSystem.dto.ProjectDTO;
import com.edonhoxha.TaskManagementSystem.entity.Project;
import com.edonhoxha.TaskManagementSystem.entity.User;
import com.edonhoxha.TaskManagementSystem.repository.ProjectRepository;
import com.edonhoxha.TaskManagementSystem.repository.UserRepository;
import com.edonhoxha.TaskManagementSystem.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public ProjectDTO createProject(ProjectDTO dto){
        User creator = userRepository.findById(dto.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("Creator user not found"));

        Set<User> members = new HashSet<>();
        if(dto.getMemberIds() != null) {
            for(Long memberId : dto.getMemberIds()){
                User member = userRepository.findById(memberId)
                        .orElseThrow(() -> new RuntimeException("Member not found: " + memberId));
                members.add(member);
            }
        }

        Project project = Project.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .createdBy(creator)
                .members(members)
                .build();

        project = projectRepository.save(project);
        return toDTO(project);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return toDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getProjectsByUserId(Long userId) {
        return projectRepository.findByCreatedBy_Id(userId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ProjectDTO toDTO(Project project) {
        List<Long> memberIds = project.getMembers()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());

        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .createdBy(project.getCreatedBy().getId())
                .memberIds(memberIds)
                .build();
    }
}
