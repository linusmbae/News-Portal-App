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

    @Test
    public void setName_setsCorrectName()throws Exception {
        Users testUser=createUser();
        testUser.setName("Lucy");
        assertNotEquals("Linus",testUser.getName());
    }

    @Test
    public void setEmail_setsCorrectEmail()throws Exception {
        Users testUser=createUser();
        testUser.setEmail("lucy@gmail.com");
        assertNotEquals("linus@gmail.com",testUser.getEmail());
    }

    @Test
    public void setPhone_setsCorrectPhone()throws Exception {
        Users testUser=createUser();
        testUser.setPhone("0712345678");
        assertNotEquals("0714719935",testUser.getPhone());
    }

    @Test
    public void setIdNumber_setsCorrectIdNumber()throws Exception {
        Users testUser=createUser();
        testUser.setIdNumber(54321);
        assertNotEquals(12345,testUser.getIdNumber());
    }

    //    HELPERS
    public Users createUser()
    {
        return new Users("Linus","linus@gmail.com","0714719935",12345);
    }
}