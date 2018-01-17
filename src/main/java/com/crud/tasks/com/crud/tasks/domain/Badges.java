package com.crud.tasks.com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Badges {
    private final int votes;
    private final AttachmentsByType attachments;

    @JsonCreator
    public Badges(@JsonProperty("votes") int votes, @JsonProperty("attachments") AttachmentsByType attachments) {
        this.votes = votes;
        this.attachments = attachments;
    }
}
