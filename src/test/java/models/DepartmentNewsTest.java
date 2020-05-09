package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentNewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContent_returnsCorrectContent()throws Exception {
        DepartmentNews testNews=createDepartmentNews();
        assertEquals("Tomorrow is a public Holiday",testNews.getContent());
    }

    @Test
    public void getType_returnsCorrectType()throws Exception {
        DepartmentNews testNews=createDepartmentNews();
        assertEquals("Department News",testNews.getType());
    }

    @Test
    public void setContent_returnsCorrectContent()throws Exception {
        DepartmentNews testNews=createDepartmentNews();
        testNews.setContent("Big up to each and every employee");
        assertNotEquals("Tomorrow is a public Holiday",testNews.getContent());
    }

    @Test
    public void setType_returnsTheCorrectType()throws Exception {
        DepartmentNews testNews =createDepartmentNews();
        testNews.setType("Department News");
        assertEquals("Department News",testNews.getType());
    }

    //    HELPER
    public DepartmentNews createDepartmentNews()
    {
        return new DepartmentNews("Tomorrow is a public Holiday");
    }
}