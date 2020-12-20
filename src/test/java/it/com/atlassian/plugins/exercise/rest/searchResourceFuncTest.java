package it.com.atlassian.plugins.exercise.rest;

import com.atlassian.plugins.exercise.rest.searchResourceModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class searchResourceFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/searchresource/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        searchResourceModel message = resource.get(searchResourceModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
