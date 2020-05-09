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

    @Test
    public void SetNewsId_setsCorrectNewsId()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setNewsId(3);
        assertNotEquals(2,testDepartment.getNewsId());
    }

    @Test
    public void SetUserId_setsCorrectUserId()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setUserId(2);
        assertNotEquals(1,testDepartment.getUserId());
    }

    @Test
    public void SetRole_setsCorrectRole()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setUserRole("Update Boss");
        assertNotEquals("Receive Calls",testDepartment.getUserRole());
    }

    @Test
    public void SetPosition_setsCorrectPosition()throws Exception {
        Department testDepartment=createDepartment();
        testDepartment.setUserPosition("Boss");
        assertNotEquals("Secretary",testDepartment.getUserPosition());
    }

    //    HELPERSgetNewsId
    public Department createDepartment()
    {
        return new Department("Raw News","Third Floor");
    }
}