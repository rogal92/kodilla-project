package com.crud.tasks.com.crud.tasks.controller;

import com.crud.tasks.com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.com.crud.tasks.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/trello")
@CrossOrigin("*")
public class TrelloControler {

    @Autowired
    private TrelloService trelloService;

    private TrelloBoardDto trelloBoardDto;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

            return trelloService.fetchTrelloBoards().stream()
                    .filter(t -> t.getId() != null && !t.getId().isEmpty())
                    .filter(t -> t.getName() != null && t.getName().contains("Kodilla"))
                    .collect(Collectors.toList());

    }
    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {

        return trelloService.createdTrelloCard(trelloCardDto);
    }
}
