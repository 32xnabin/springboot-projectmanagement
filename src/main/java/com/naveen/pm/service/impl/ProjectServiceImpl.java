package com.naveen.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.pm.model.Project;
import com.naveen.pm.repository.ProjectRepository;
import com.naveen.pm.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

    @Override
    public Project findProjectById(long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void save(Project project) {
    	projectRepository.save(project);
    }

    @Override
    public void edit(Project project) {
    	projectRepository.save(project);
    }

    @Override
    public void delete(long id) {
    	projectRepository.deleteById(id);
    }
}

