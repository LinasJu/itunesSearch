package com.atlassian.plugins.exercise.rest;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CustomSerializer implements JsonSerializer<Artists> {

    @Override
    public JsonElement serialize(Artists artists, Type type, JsonSerializationContext context) {
        JsonArray jsonArtists = new JsonArray();
        for (Artist artist : artists.getArtistList()) {
            JsonObject jsonArtist = new JsonObject();
            jsonArtist.addProperty("name", artist.getName());
            jsonArtist.addProperty("link", artist.getLink());
            jsonArtist.addProperty("id", artist.getId());
            jsonArtist.addProperty("genre", artist.getGenreId());

            jsonArtists.add(jsonArtist);
        }
        return jsonArtists;
    }
}

