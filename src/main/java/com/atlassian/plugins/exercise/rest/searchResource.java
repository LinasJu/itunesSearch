package com.atlassian.plugins.exercise.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import kong.unirest.Unirest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import static kong.unirest.Cache.builder;

/**
 * A resource of message.
 */
@Path("/message")
public class searchResource {
    private final Long CACHE_TIME = 3L;
    private final TimeUnit CACHE_TIME_UNIT = TimeUnit.MINUTES;
    private final String BASE_URL = "https://itunes.apple.com/search";
    private final String USERNAME = "ADMIN";//kol kas hardcode'inta
    private final String PASSWORD = "ADMIN";

    public Response getMessage(@QueryParam("key") String key) {
        if (key != null) {
            return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
        } else {
            return Response.ok(new searchResourceModel("default", null)).build();
        }
    }

    @GET
    @AnonymousAllowed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getMessageFromPath(@QueryParam("key") String key) {
        return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
    }

    public String getMessageFromKey(String key) {//todo i private
        if (key == null || key.isEmpty()) {
            return "No Key value passed. Please input value.";
        }

        Unirest.config().cacheResponses(builder()
                .maxAge(CACHE_TIME, CACHE_TIME_UNIT)); // Max age is how long the entry will be kept.

        Artists artists = Unirest.get(BASE_URL)
                //    .basicAuth(USERNAME, PASSWORD) //todo check authentification
                .queryString("entity", "allArtist")
                .queryString("term", key) // if no artists are fetched returns empty list
                .asObject(Artists.class)
                .getBody();

        /*Unirest.get("http://somewhere")
                .asJson()
                .ifSuccess(response -> someSuccessMethod(response))
                .ifFailure(response -> {
                    log.error("Oh No! Status" + response.getStatus());
                    response.getParsingError().ifPresent(e -> {
                        log.error("Parsing Exception: ", e);
                        log.error("Original body: " + e.getOriginalBody());
                    });
                });*/

        // GsonBuilder gsonBuilder = new GsonBuilder();

        Type artistsType = new TypeToken<Artists>() {
        }.getType();
        Gson customGson = new GsonBuilder().registerTypeAdapter(artistsType, new CustomSerializer()).create();
        return customGson.toJson(artists);
    }
}