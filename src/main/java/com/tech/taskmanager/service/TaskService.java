package com.tech.taskmanager.service;

import com.tech.taskmanager.model.Task;
import com.tech.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        task.setStatus("Pending"); // default status
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(existing -> {
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
            existing.setDueDate(updatedTask.getDueDate());
            existing.setStatus(updatedTask.getStatus());
            return taskRepository.update(existing);
        });
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.delete(id);
            return true;
        }
        return false;
    }
}
