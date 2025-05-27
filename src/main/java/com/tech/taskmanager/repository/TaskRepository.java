package com.tech.taskmanager.repository;

import com.tech.taskmanager.model.Task;

import java.util.*;


public interface TaskRepository  {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    Task update(Task task);
    void delete(Long id);
}
