package com.tech.taskmanager.repository;

import com.tech.taskmanager.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTaskRepository();
    }

    @Test
    void testSave() {
        Task task = new Task(null, "Test Task", "Description", LocalDate.now(), "Pending");
        Task savedTask = repository.save(task);

        assertNotNull(savedTask.getId());
        assertEquals("Test Task", savedTask.getTitle());
    }

    @Test
    void testFindById() {
        Task task = new Task(null, "Test Task", "Description", LocalDate.now(), "Pending");
        Task savedTask = repository.save(task);

        Optional<Task> foundTask = repository.findById(savedTask.getId());
        assertTrue(foundTask.isPresent());
        assertEquals(savedTask.getId(), foundTask.get().getId());
    }

    @Test
    void testFindAll() {
        Task task1 = new Task(null, "Task 1", "Description 1", LocalDate.now(), "Pending");
        Task task2 = new Task(null, "Task 2", "Description 2", LocalDate.now(), "Completed");

        repository.save(task1);
        repository.save(task2);

        List<Task> tasks = repository.findAll();
        assertEquals(2, tasks.size());
    }

    @Test
    void testUpdate() {
        Task task = new Task(null, "Old Title", "Old Description", LocalDate.now(), "Pending");
        Task savedTask = repository.save(task);

        savedTask.setTitle("New Title");
        savedTask.setDescription("New Description");
        Task updatedTask = repository.update(savedTask);

        assertEquals("New Title", updatedTask.getTitle());
        assertEquals("New Description", updatedTask.getDescription());
    }

    @Test
    void testDelete() {
        Task task = new Task(null, "Test Task", "Description", LocalDate.now(), "Pending");
        Task savedTask = repository.save(task);

        repository.delete(savedTask.getId());
        Optional<Task> deletedTask = repository.findById(savedTask.getId());

        assertFalse(deletedTask.isPresent());
    }
}