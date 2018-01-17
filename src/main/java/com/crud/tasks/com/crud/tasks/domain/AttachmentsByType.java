package com.crud.tasks.com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class AttachmentsByType {

    public final Trello trello;

    @JsonCreator
    public AttachmentsByType(@JsonProperty("trello") Trello trello) {
        this.trello = trello;
    }
}
