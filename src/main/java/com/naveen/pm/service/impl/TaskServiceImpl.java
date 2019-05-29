package com.naveen.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.pm.model.Task;
import com.naveen.pm.repository.TaskRepository;
import com.naveen.pm.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void save(Task task) {
    	taskRepository.save(task);
    }

    @Override
    public void edit(Task task) {
    	taskRepository.save(task);
    }

    @Override
    public void delete(long id) {
    	taskRepository.deleteById(id);
    }
}
