package com.crud.tasks.com.crud.tasks.controller;

import com.crud.tasks.com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    public TaskDto getTask(String taskId) {
        return new TaskDto((long)1,"test title","test_content");
    }

    public void deleteTask(String taskId) {

    }

    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto((long)1,"Editet task title","Test content");
    }
    public void createTask(TaskDto taskDto) {}
}
