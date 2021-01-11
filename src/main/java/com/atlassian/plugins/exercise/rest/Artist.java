package com.atlassian.plugins.exercise.rest;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {
    @SerializedName("artistName")
    protected String name;
    @SerializedName("artistLinkUrl")
    protected String link;
    @SerializedName("artistId")
    protected Long id;
    @SerializedName("primaryGenreName")
    protected String genre;
    @SerializedName("primaryGenreId")
    protected Long genreId;
}
