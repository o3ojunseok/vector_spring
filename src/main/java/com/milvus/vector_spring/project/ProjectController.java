package com.milvus.vector_spring.project;

import com.milvus.vector_spring.project.dto.ProjectContentsResponseDto;
import com.milvus.vector_spring.project.dto.ProjectCreateRequestDto;
import com.milvus.vector_spring.project.dto.ProjectResponseDto;
import com.milvus.vector_spring.project.dto.ProjectUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping()
    public List<ProjectResponseDto> findAllProjects() {
        List<Project> projects = projectService.findAllProject();
        return projects.stream()
                .map(ProjectResponseDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public ProjectResponseDto findOneProject(@PathVariable Long id) {
        Project project = projectService.findOneProject(id);
        return ProjectResponseDto.of(project);
    }

    @GetMapping("/search")
    public ProjectResponseDto findOneProjectByKey(@RequestParam String key) {
        Project project = projectService.findOneProjectByKey(key);
        return ProjectResponseDto.of(project);
    }

    @GetMapping("/contents")
    public ProjectContentsResponseDto findOneProjectWithContents(@RequestParam String key) {
        return projectService.findOneProjectWithContents(key);
    }

    @PostMapping("/create")
    public ProjectResponseDto createProject(@Validated @RequestBody ProjectCreateRequestDto projectCreateRequestDto) {
        Project project = projectService.createProject(projectCreateRequestDto);
        return ProjectResponseDto.of(project);
    }

    @PostMapping("/update")
    public ProjectResponseDto updateProject(@RequestParam() String key, ProjectUpdateRequestDto projectUpdateRequestDto) {
        Project project = projectService.updateProject(key, projectUpdateRequestDto);
        return ProjectResponseDto.of(project);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProject(@RequestParam String key) {
        String deleteProject = projectService.deleteProject(key);
        return ResponseEntity.ok(deleteProject);
    }
}
