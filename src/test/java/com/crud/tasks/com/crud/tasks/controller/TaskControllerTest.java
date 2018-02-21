package com.crud.tasks.com.crud.tasks.controller;

import com.crud.tasks.com.crud.tasks.domain.Task;
import com.crud.tasks.com.crud.tasks.domain.TaskDto;
import com.crud.tasks.com.crud.tasks.mapper.TaskMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TaskMapper taskMapper;

    @Test
    public void shouldGetZeroTasks() throws Exception {
        //given
        List<Task> tasks = new ArrayList<>();
        List<TaskDto> taskDtos = new ArrayList<>();
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(taskDtos);

        //when&then
        mockMvc.perform(get("/v1/task/getTasks/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(0)));
    }
    @Test
    public void shouldGetTaskByID() throws Exception {
        //given
        TaskDto taskDto = new TaskDto();
        Task task = new Task();

        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
    }
    @Test
    public void shouldCreateTask() throws Exception {
        //given
        TaskDto taskDto = new TaskDto(
                1L,
                "Test title",
                "Test content");
        when(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class))).thenReturn(new Task());
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //when&then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonContent))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Test title"))
                .andExpect(jsonPath("$[0].content").value("Test content"));
    }
    @Test
    public void shouldUpdateTask() throws Exception {
        //given
        TaskDto taskDto = new TaskDto(
                1L,
                "Test title",
                "Test content");
        when(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class))).thenReturn(new Task());
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        // when & then
        mockMvc.perform(put("/v1/task/updateTask")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(jsonContent))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Test title"))
                .andExpect(jsonPath("$[0].content").value("Test content"));
    }
}
















//    @RequestMapping(method = RequestMethod.POST , value = "createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createTask(@RequestBody TaskDto taskDto) {
//        service.saveTask(taskMapper.mapToTask(taskDto));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
//    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
//        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
//    public List<TaskDto> getTasks() {
//        return service.getAllTasks().stream()
//                .map(t ->taskMapper.mapToTaskDto(t))
//                .collect(Collectors.toList());
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "getTask/{id}")
//    public TaskDto getTask(@PathVariable("id") Long taskId) {
//        return taskMapper.mapToTaskDto(service.getTaskById(taskId));
//    }
//package com.crud.tasks.com.crud.tasks.controller;
//
//        import com.crud.tasks.com.crud.tasks.domain.CreatedTrelloCardDto;
//        import com.crud.tasks.com.crud.tasks.domain.TrelloBoardDto;
//        import com.crud.tasks.com.crud.tasks.domain.TrelloCardDto;
//        import com.crud.tasks.com.crud.tasks.domain.TrelloListDto;
//        import com.crud.tasks.com.crud.tasks.trello.facade.TrelloFacade;
//        import com.google.gson.Gson;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.mockito.ArgumentMatchers;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//        import org.springframework.boot.test.mock.mockito.MockBean;
//        import org.springframework.http.MediaType;
//        import org.springframework.test.context.junit4.SpringRunner;
//        import org.springframework.test.web.servlet.MockMvc;
//
//        import java.awt.*;
//        import java.util.ArrayList;
//        import java.util.List;
//
//        import static org.hamcrest.Matchers.hasSize;
//        import static org.hamcrest.Matchers.hasValue;
//        import static org.hamcrest.Matchers.is;
//        import static org.mockito.ArgumentMatchers.anyBoolean;
//        import static org.mockito.Mockito.when;
//        import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
//        import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//        import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(TrelloControler.class)
//public class TrelloControlerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TrelloFacade trelloFacade;
//
//    @Test
//    public void shouldFetchEmptyTrelloBoards() throws Exception{
//        //given
//        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
//        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoards);
//
//        //when&then
//        mockMvc.perform(get("/v1/trello/getTrelloBoards").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",hasSize(0)));
//    }
//    @Test
//    public void shouldFetchTrelloBoards() throws Exception {
//        //Given
//        List<TrelloListDto> trelloLists = new ArrayList<>();
//        trelloLists.add(new TrelloListDto("1","Test Task", false));
//
//        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
//        trelloBoards.add(new TrelloBoardDto("1","Test Task",trelloLists));
//
//        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoards);
//
//        //when&then
//        mockMvc.perform(get("/v1/rello/getTrelloBoards").contentType(MediaType.APPLICATION_JSON))
//                //trello board fields
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",hasSize(1)))
//                .andExpect(jsonPath("$[0].id",is("1")))
//                .andExpect(jsonPath("$[0],name",is("Test Task")))
//                //Trello list fields
//                .andExpect(jsonPath("$[0].lists",is(hasSize(1))))
//                .andExpect(jsonPath("$[0].lists[0].id",is("1")))
//                .andExpect(jsonPath("$[0].lists[0].name",is("Test List")))
//                .andExpect(jsonPath("$[0].lists[0].closed",is(false)));
//    }
//    @Test
//    public void shouldCreatetrelloCard() throws Exception {
//        //given
//
//        TrelloCardDto trelloCardDto = new TrelloCardDto(
//                "Test",
//                "Test descritpion",
//                "top",
//                "1");
//
//        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto(
//                "323",
//                "Test",
//                "http://test.com");
//        when(trelloFacade.createCard(ArgumentMatchers.any(TrelloCardDto.class))).thenReturn(createdTrelloCardDto);
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(trelloCardDto);
//
//        //when&then
//        mockMvc.perform(post("/v1/trello/createTrelloCard")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent)
//                .andExpect(jsonPath("$.id",is(323)))
//                .andExpect(jsonPath("$.name",is("Test")))
//                .andExpect(jsonPath("$.shortUrl",is("http://test.com"))));
//    }
//}