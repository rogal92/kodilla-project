package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Trello {

    public final int board;
    public final int card;

    @JsonCreator
    public Trello(@JsonProperty("board") int board,@JsonProperty("card") int card) {
        this.board = board;
        this.card = card;
    }
}
