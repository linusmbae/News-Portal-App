package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralNewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContent_returnsCorrectContent()throws Exception {
        GeneralNews testNews=createGeneralNews();
        assertEquals("Tomorrow is a public Holiday",testNews.getContent());
    }

    @Test
    public void getType_returnsCorrectType()throws Exception {
        GeneralNews testNews=createGeneralNews();
        assertEquals("General News",testNews.getType());
    }

    @Test
    public void setContent_returnsCorrectContent()throws Exception {
        GeneralNews testNews=createGeneralNews();
        testNews.setContent("Big up to each and every employee");
        assertNotEquals("Tomorrow is a public Holiday",testNews.getContent());
    }

    @Test
    public void setType_returnsTheCorrectType()throws Exception {
        GeneralNews testNews =createGeneralNews();
        testNews.setType("General News");
        assertEquals("General News",testNews.getType());
    }

    //    HELPER
public GeneralNews createGeneralNews()
{
    return new GeneralNews("Tomorrow is a public Holiday");
}
}