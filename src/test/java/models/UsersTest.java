package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName_returnsCorrectName()throws Exception {
        Users testUser=createUser();
        assertEquals("Linus",testUser.getName());
    }

    @Test
    public void getEmail_returnsCorrectEmail()throws Exception {
        Users testUser=createUser();
        assertEquals("linus@gmail.com",testUser.getEmail());
    }

    @Test
    public void getPhone_returnsCorrectPhone()throws Exception {
        Users testUser=createUser();
        assertEquals("0714719935",testUser.getPhone());
    }

    @Test
    public void getIdNumber_returnsCorrectIdNumber()throws Exception {
        Users testUser=createUser();
        assertEquals(12345,testUser.getIdNumber());
    }

    //    HELPERS
    public Users createUser()
    {
        return new Users("Linus","linus@gmail.com","0714719935",12345);
    }
}