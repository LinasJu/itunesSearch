package ut.com.atlassian.plugins.exercise;

import org.junit.Test;
import com.atlassian.plugins.exercise.api.MyPluginComponent;
import com.atlassian.plugins.exercise.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}