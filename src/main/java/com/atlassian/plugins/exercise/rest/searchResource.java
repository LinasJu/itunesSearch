package com.atlassian.plugins.exercise.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A resource of message.
 */
@Path("/message")
public class searchResource {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public Response getMessage(@QueryParam("key") String key) throws Exception {
        if (key != null) {
            return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
        } else {
            return Response.ok(new searchResourceModel("default", "Hello World")).build();
        }
    }

    @GET
    @AnonymousAllowed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getMessageFromPath(@QueryParam("key") String key) throws Exception {
        return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
    }

    private String getMessageFromKey(String key) throws Exception {
        String jsonResponseFromItunes;

        try {
            jsonResponseFromItunes = getPostRequestsResponse(key);
        } finally {
            close();
        }

        if (jsonResponseFromItunes == null) {
            return "no response";
        }
//        return getNeededArtistInfoToDisplay(jsonResponseFromItunes);
        return jsonResponseFromItunes;
    }
/*
    private String getNeededArtistInfoToDisplay(String jsonResponseFromItunes) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Artist> artists = objectMapper.readValue(jsonResponseFromItunes, new TypeReference<List<Artist>>() {});
        return objectMapper.writeValueAsString(artists);
    }*/

    private String getPostRequestsResponse(String key) throws Exception {
        HttpPost post = new HttpPost("https://itunes.apple.com/search");

        // add request parameter, form parameters
        List<BasicNameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("entity", "allArtist"));
        urlParameters.add(new BasicNameValuePair("term", key));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            return EntityUtils.toString(response.getEntity());
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }
}