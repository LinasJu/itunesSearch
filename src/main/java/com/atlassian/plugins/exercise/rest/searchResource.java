package com.atlassian.plugins.exercise.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/message")
public class searchResource {

    public Response getMessage(@QueryParam("key") String key)
    {
        if (key!=null) {
            return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
        }
        else {
            return Response.ok(new searchResourceModel("default","Hello World")).build();
        }
    }

    @GET
    @AnonymousAllowed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getMessageFromPath(@QueryParam("key") String key)
    {
       return Response.ok(new searchResourceModel(key, getMessageFromKey(key))).build();
    }

    private String getMessageFromKey(String key) {
		/*HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://itunes.apple.com/search?");

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("entity", "allArtist"));
		params.add(new BasicNameValuePair("term", key));
		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				String responseString = out.toString();
				out.close();
			}
		}*/
        return key + key;
    }
}