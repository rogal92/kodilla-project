package com.crud.tasks.mapper;

import com.crud.tasks.com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.com.crud.tasks.domain.TrelloList;
import com.crud.tasks.com.crud.tasks.mapper.TrelloMapper;
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

}
//    @Test
//    public void testMapTrelloBoards() {
//        //Given
//        List<TrelloList> trelloLists = new ArrayList<>();
//        trelloLists.add(new TrelloList("1","boardName",true));
//
//        TrelloBoard trelloBoard = new TrelloBoard("1","trelloBoard",trelloLists);
//
//        TrelloBoardDto trelloBoardDto =
//
//        //When
//
//
//        //Then
//
//
//    }
//}


//
//package com.crud.tasks.com.crud.tasks.mapper;
//
//        import com.crud.tasks.com.crud.tasks.domain.*;
//
//        import java.util.stream.Collector;
//        import java.util.stream.Collectors;
//
//        import java.util.List;
//
//public class TrelloMapper {
//
//    public List<TrelloBoard> mapToBoards(final List<TrelloBoardDto> trelloBoardDto) {
//        return trelloBoardDto.stream()
//                .map(trelloBoard -> new TrelloBoard(trelloBoard.getId(), trelloBoard.getName(), mapToList(trelloBoard.getLists())))
//                .collect(Collectors.toList());
//    }
//
//    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> trelloBoards) {
//        return trelloBoards.stream()
//                .map(trelloBoard -> new TrelloBoardDto(trelloBoard.getId(), trelloBoard.getName(), mapToListDto(trelloBoard.getLists())))
//                .collect(Collectors.toList());
//    }
//    public List<TrelloList> mapToList(final List<TrelloListDto> trelloListDtos) {
//        return trelloListDtos.stream()
//                .map(trelloList -> new TrelloList(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
//                .collect(Collectors.toList());
//    }
//    public List<TrelloListDto> mapToListDto(final List<TrelloList> trelloLists) {
//        return trelloLists.stream()
//                .map(trelloList -> new TrelloListDto(trelloList.getId(),trelloList.getName(), trelloList.isClosed()))
//                .collect(Collectors.toList());
//    }
//    public TrelloCardDto mapToCardDto(final TrelloCard trelloCard) {
//        return new TrelloCardDto(trelloCard.getName(),trelloCard.getDescription(),trelloCard.getPos(),trelloCard.getListId());
//    }
//
//    public TrelloCard mapToCard(final TrelloCardDto trelloCardDto) {
//        return new TrelloCard(trelloCardDto.getName(),trelloCardDto.getDescription(),trelloCardDto.getPos(),trelloCardDto.getListId());
//    }
//}