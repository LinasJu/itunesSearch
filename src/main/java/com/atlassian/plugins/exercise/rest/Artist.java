package com.atlassian.plugins.exercise.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {

   // @JsonProperty("artistName")
    String name;
//    @JsonProperty("artistLinkUrl")
    String link;
//    @JsonProperty("artistId")
    Long id;
//    @JsonProperty("primaryGenreName")
    String genre;
//    @JsonProperty("primaryGenreId")
    Long genreId;
}