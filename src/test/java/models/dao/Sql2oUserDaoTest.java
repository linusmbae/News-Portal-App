package models.dao;

import models.Users;
import org.junit.*;
import org.sql2o.*;


import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private static Connection conn;
    private static Sql2oUserDao userDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "12345");
        System.out.println("Connection Initialized");
        userDao=new Sql2oUserDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clear Database");
        userDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception
    {
        conn.close();
        System.out.println("Connection Closed");
    }

    @Test
    public void save_createsNewUserAndAssignsNewId()throws Exception {
        Users testUser=createUser();
        int originalId=testUser.getId();
        userDao.save(testUser);
        assertNotEquals(originalId,testUser.getId());
    }

    @Test
    public void getAll_returnsAllSavedUsers()throws Exception {
        Users testUser=createUser();
        userDao.save(testUser);
        Users testSecondUser=createUser();
        userDao.save(testSecondUser);
        assertEquals(2,userDao.getAll().size());
    }

//    @Test
//    public void getById_ReturnsUserById()throws Exception {
//        Users testUser=createUser();
//        userDao.save(testUser);
//        Users testSecondUser=createUser();
//        userDao.save(testSecondUser);
//        assertTrue(userDao.findById(testSecondUser.getId()).equals(testSecondUser.getId()));
//    }


    @Test
    public void noNullValueIsReturned()throws Exception {
       assertEquals(0,userDao.getAll().size());
    }

    @Test
    public void clearAll_emptyUserList()throws Exception {
        Users testUser=createUser();
        userDao.save(testUser);
        Users testSecondUser=createUser();
        userDao.save(testSecondUser);
        userDao.clearAll();
        assertEquals(0,userDao.getAll().size());
    }

    @Test
    public void removeById_RemovesASpecificUser()throws Exception {
        Users testUser=createUser();
        userDao.save(testUser);
        Users testSecondUser=createUser();
        userDao.save(testSecondUser);
        userDao.removeById(testSecondUser.getId());
        assertEquals(1,userDao.getAll().size());
    }

    //    HELPER
    public Users createUser()
    {
        return new Users("Linus","linus@qmail.com","0714719935",12345);
    }
}