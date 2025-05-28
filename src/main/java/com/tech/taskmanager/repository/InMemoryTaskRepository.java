package com.tech.taskmanager.repository;

import com.tech.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository implements TaskRepository {
    private final Map<Long, Task> taskStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Task save(Task task) {
        Long id = idGenerator.getAndIncrement();
        task.setId(id);
        taskStore.put(id, task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {

        return Optional.ofNullable(taskStore.get(id));
    }

    @Override
    public List<Task> findAll() {

        return new ArrayList<>(taskStore.values());
    }

    @Override
    public Task update(Task task) {
        taskStore.put(task.getId(), task);
        return task;
    }

    @Override
    public void delete(Long id) {
        taskStore.remove(id);
    }
}
