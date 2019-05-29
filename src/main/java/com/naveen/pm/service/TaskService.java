
package com.naveen.pm.service;

import java.util.List;

import com.naveen.pm.model.Task;

public interface TaskService {

    public List<Task> getTaskList();

    public Task findTaskById(long id);

    public void save(Task task);

    public void edit(Task task);

    public void delete(long id);


}

