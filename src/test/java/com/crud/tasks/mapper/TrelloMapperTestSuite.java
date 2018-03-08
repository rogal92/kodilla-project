package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();

        //When
        List<TrelloBoard> test = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(trelloBoardList,test );
    }

    @Test
    public void testMapToBoardsDto() {
        //given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();

        //when
        List<TrelloBoardDto> test = trelloMapper.mapToBoardsDto(trelloBoardList);

        //then
        Assert.assertEquals(test, trelloBoardDtoList);
    }
    @Test
    public void testMapToList() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();

        //WHen
        List<TrelloList> test = trelloMapper.mapToList(trelloListDtos);

        //Then
        Assert.assertEquals(test, trelloLists);
    }
    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();

        //WHen
        List<TrelloListDto> test = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals(test, trelloListDtos);
    }
    @Test
    public void testMapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name","description","1","1");
        TrelloCard trelloCard = new TrelloCard("name","description","1","1");

        //when
        TrelloCard trelloCardOne = trelloMapper.mapToCard(trelloCardDto);

        //then
        Assert.assertEquals(trelloCardOne,trelloCard);
    }
    @Test
    public void testMapToCardDto() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name","description","1","1");
        TrelloCard trelloCard = new TrelloCard("name","description","1","1");

        //when
        TrelloCardDto trelloCardDtoOne = trelloMapper.mapToCardDto(trelloCard);

        //then
        Assert.assertEquals(trelloCardDtoOne,trelloCardDto);
    }
}