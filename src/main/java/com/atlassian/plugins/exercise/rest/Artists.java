package com.atlassian.plugins.exercise.rest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Artists {
    @SerializedName("results") protected ArrayList<Artist> artists;

}
