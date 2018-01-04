package com.crud.tasks.com.crud.tasks.service;

import com.crud.tasks.com.crud.tasks.domain.Task;
import com.crud.tasks.com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Task getTaskById(long id) {
        return repository.findById(id).orElse(null);
    }
    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public Optional<Task> getTask(final long id) {
        return repository.findById(id);
    }
    public Task deleteTask(final Task task) {
        return repository.delete(task);
    }

    public DbService() {
    }
}
