package com.atlassian.plugins.exercise.rest;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class ArtistSerializer extends StdSerializer<Artist> {
//todo custom deserializer
    public ArtistSerializer() {
        this(null);
    }

    public ArtistSerializer(Class<Artist> t) {
        super(t);
    }

    @Override
    public void serialize(
            Artist artist, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("name", artist.name);
        jgen.writeStringField("link", artist.link);
        jgen.writeNumberField("id", artist.id);
        jgen.writeStringField("genre", artist.genre);
        jgen.writeNumberField("genreId", artist.genreId);
        jgen.writeEndObject();
    }
}
}
