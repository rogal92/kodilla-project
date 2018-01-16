package com.crud.tasks.com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private Badges badges;

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachments")
    private AttachmentsByType attachments;

    @JsonProperty("trello")
    private Trello trello;

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

    public final static class Badges {
        private final int votes;
        private final AttachmentsByType attachments;

        @JsonCreator
        public Badges(@JsonProperty("votes") int votes, @JsonProperty("attachments") AttachmentsByType attachments) {
            this.votes = votes;
            this.attachments = attachments;
        }
    }
}
