package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //given
        Task task = new Task(1L,"title","content");
        TaskDto taskDto = new TaskDto(1L,"title","content");

        //when
        boolean isEqual = taskMapper.mapToTask(taskDto).equals(task);

        //then
        Assert.assertTrue(isEqual);
    }
    @Test
    public void testMapToTaskDto() {
        //given
        Task task = new Task(2L,"title","content");
        TaskDto taskDto = new TaskDto(2L,"title","content");

        //when
        boolean isEqual = taskMapper.mapToTaskDto(task).equals(taskDto);

        //then
        Assert.assertTrue(isEqual);
    }
    @Test
    public void testMapToTaskListDto() {
        //given
        List<Task> tasks = new ArrayList<>();
        List<TaskDto> taskDtos = new ArrayList<>();
        TaskDto taskDto = new TaskDto(3L,"title","content");
        Task task = new Task(3L,"title","content");


        //when
        List<TaskDto> taskDtoList = new ArrayList<>();
        tasks.add(task);
        taskDtos.add(taskDto);

        taskDtoList = taskMapper.mapToTaskDtoList(tasks);

        //then
        Assert.assertEquals(taskDtoList,taskDtos);
    }
}