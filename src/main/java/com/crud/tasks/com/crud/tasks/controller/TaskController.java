package com.crud.tasks.com.crud.tasks.controller;

import com.crud.tasks.com.crud.tasks.domain.TaskDto;
import com.crud.tasks.com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.com.crud.tasks.service.DbService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask/{id}")
    public TaskDto getTask(@PathVariable("id") String taskId) {
        return new TaskDto((long)1,"test title","test_content");
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask/{id}")
    public void deleteTask(@PathVariable("id") String taskId) {
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return new TaskDto((long)1,"Edited test title","Test content");
    }
    @RequestMapping(method = RequestMethod.POST , value = "createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }
}
