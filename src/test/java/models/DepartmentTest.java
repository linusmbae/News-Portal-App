package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName_returnsCorrectName()throws Exception {
        Department testDepartment = createDepartment();
        assertEquals("Raw News",testDepartment.getName());
    }

    @Test
    public void getFloor_returnsCorrectFloor()throws Exception {
        Department testDepartment=createDepartment();
        assertEquals("Third Floor",testDepartment.getFloor());
    }

    @Test
    public void SetName_setsCorrectName()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setName("News");
        assertNotEquals("Raw News",testDepartment.getName());
    }

    @Test
    public void setFloor_setsCorrectFloor()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setFloor("Second Floor");
        assertNotEquals("Third Floor",testDepartment.getFloor());
    }

    //    HELPERS
    public Department createDepartment()
    {
        return new Department("Raw News","Third Floor");
    }
}