package com.naveen.pm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naveen.pm.ResourceNotFoundException;
import com.naveen.pm.model.Project;
import com.naveen.pm.repository.ProjectRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project Project) {
        return projectRepository.save(Project);
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable(value = "id") Long ProjectId) {
        return projectRepository.findById(ProjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", ProjectId));
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable(value = "id") Long ProjectId,
                                           @Valid @RequestBody Project ProjectDetails) {

        Project Project = projectRepository.findById(ProjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", ProjectId));

        Project.setTitle(ProjectDetails.getTitle());
        Project.setDescription(ProjectDetails.getDescription());

        Project updatedProject = projectRepository.save(Project);
        return updatedProject;
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Long ProjectId) {
        Project Project = projectRepository.findById(ProjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", ProjectId));

        projectRepository.delete(Project);

        return ResponseEntity.ok().build(); 
    }
}

