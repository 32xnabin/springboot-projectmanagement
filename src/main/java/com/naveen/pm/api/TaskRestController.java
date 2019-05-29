package com.naveen.pm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naveen.pm.ResourceNotFoundException;
import com.naveen.pm.model.Task;
import com.naveen.pm.repository.TaskRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task", "id", taskId));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable(value = "id") Long taskId,
                                           @Valid @RequestBody Task taskDetails) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task", "id", taskId));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
      //  task.setProject(taskDetails.getProject());
        

        Task updatedTask = taskRepository.save(task);
        return updatedTask;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) {
        Task Task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task", "id", taskId));

        taskRepository.delete(Task);

        return ResponseEntity.ok().build(); 
    }
}

