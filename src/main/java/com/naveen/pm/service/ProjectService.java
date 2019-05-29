
package com.naveen.pm.service;

import java.util.List;

import com.naveen.pm.model.Project;

public interface ProjectService {

    public List<Project> getProjectList();

    public Project findProjectById(long id);

    public void save(Project project);

    public void edit(Project project);

    public void delete(long id);


}
