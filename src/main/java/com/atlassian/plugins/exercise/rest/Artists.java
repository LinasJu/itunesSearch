package com.atlassian.plugins.exercise.rest;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Artists {
    @SerializedName("results")
    protected ArrayList<Artist> artistList;

}
