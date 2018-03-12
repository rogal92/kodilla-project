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
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("1","test",trelloLists);

        //When
        List<TrelloBoard> test = trelloMapper.mapToBoards(trelloBoardDtoList);
        test.add(trelloBoard);

        trelloBoardList.add(trelloBoard);

        //Then
        Assert.assertEquals(trelloBoardList,test);
    }

    @Test
    public void testMapToBoardsDto() {
        //given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1","test",trelloListsDto);

        //when
        List<TrelloBoardDto> test = trelloMapper.mapToBoardsDto(trelloBoardList);
        test.add(trelloBoardDto);

        trelloBoardDtoList.add(trelloBoardDto);

        //then
        Assert.assertEquals(test, trelloBoardDtoList);
    }
    @Test
    public void testMapToList() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        TrelloList trelloList = new TrelloList("1","list",true);

        //WHen
        List<TrelloList> test = trelloMapper.mapToList(trelloListDtos);
        test.add(trelloList);

        trelloLists.add(trelloList);

        //Then
        Assert.assertEquals(test, trelloLists);
    }
    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        TrelloListDto trelloListDto = new TrelloListDto("1","list",true);

        //WHen
        List<TrelloListDto> test = trelloMapper.mapToListDto(trelloLists);
        test.add(trelloListDto);

        trelloListDtos.add(trelloListDto);

        //Then
        Assert.assertEquals(test, trelloListDtos);
    }
    @Test
    public void testMapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name","description","1","1");
        TrelloCard trelloCard = new TrelloCard("name","description","1","1");

        //when
        boolean isEqual = trelloCard.equals(trelloMapper.mapToCard(trelloCardDto));


        //then
        Assert.assertTrue(isEqual);
    }
    @Test
    public void testMapToCardDto() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name","description","1","1");
        TrelloCard trelloCard = new TrelloCard("name","description","1","1");

        //when
        boolean isEqual = trelloCardDto.equals(trelloMapper.mapToCardDto(trelloCard));

        //then
        Assert.assertTrue(isEqual);
    }
}