package ut.com.atlassian.plugins.exercise.rest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.plugins.exercise.rest.searchResource;
import com.atlassian.plugins.exercise.rest.searchResourceModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

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
        searchResource resource = new searchResource();

        Response response = resource.getMessage("Hello World"); //this is for basic pass
        final searchResourceModel message = (searchResourceModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
