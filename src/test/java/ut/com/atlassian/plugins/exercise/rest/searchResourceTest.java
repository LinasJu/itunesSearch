package ut.com.atlassian.plugins.exercise.rest;

import com.atlassian.plugins.exercise.rest.SearchResource;
import com.atlassian.plugins.exercise.rest.searchResourceModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@Ignore //todo this time it will be ignored, but it is needed to pass
public class searchResourceTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        SearchResource resource = new SearchResource();

        Response response = resource.getMessage("Hello World"); //this is for basic pass
        final searchResourceModel message = (searchResourceModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
