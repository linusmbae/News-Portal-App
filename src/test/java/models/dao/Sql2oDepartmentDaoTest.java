package models.dao;

import models.Department;
import models.Users;
import org.junit.*;
import org.sql2o.*;


import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Connection conn;
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oUserDao userDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "12345");
        System.out.println("Connection Initialized");
        departmentDao=new Sql2oDepartmentDao(sql2o);
        userDao=new Sql2oUserDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clear Database");
        departmentDao.clearAll();
        userDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception
    {
        conn.close();
        System.out.println("Connection Closed");
    }

    @Test
    public void save_createsNewdepartment()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);
        assertEquals(1,departmentDao.getAll().size());
    }

    @Test
    public void getAll_returnsAllInstancesOfDepartment()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);
        Department testSecondDepartment=createDepartment();
        departmentDao.save(testSecondDepartment);
        assertEquals(2,departmentDao.getAll().size());
    }

    @Test
    public void findById_returnsInstanceOfDepartmentById()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);
        Department testSecondDepartment=createDepartment();
        departmentDao.save(testSecondDepartment);
        assertEquals(departmentDao.findById(testSecondDepartment.getId()),testSecondDepartment);
    }

    @Test
    public void noNullValueReturned()throws Exception {
        assertEquals(0,departmentDao.getAll().size());
    }

//    @Test
//    public void update_updatesInstanceOfTheDepartment()throws Exception {
//        Department testDepartment=createDepartment();
//        departmentDao.update(testDepartment.getId(),"Jambo","Third");
//        Department updatedDepartment=departmentDao.findById(testDepartment.getId());
//        assertEquals("Jambo",updatedDepartment.getName());
//        assertEquals("Third",updatedDepartment.getFloor());
//    }


    @Test
    public void clearAll_clearsAllInstances()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);
        Department testSecondDepartment=createDepartment();
        departmentDao.save(testSecondDepartment);
        departmentDao.clearAll();
        assertEquals(0,departmentDao.getAll().size());
    }

    @Test
    public void removeById_ClearsInstanceById()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);
        Department testSecondDepartment=createDepartment();
        departmentDao.save(testSecondDepartment);
        departmentDao.deleteById(testSecondDepartment.getId());
        assertEquals(1,departmentDao.getAll().size());
    }

    @Test
    public void addUserToDepartment_addsCorrectly()throws Exception {
        Department testDepartment=createDepartment();
        departmentDao.save(testDepartment);

//        SAVE USER ROLES
        Users userOne=new Users(testDepartment.getId(),2,3,"Receive Calls","Secretary");
        userDao.save(userOne);
        Users userTwo=new Users(testDepartment.getId(),2,3,"Receive Calls","Secretary");
        userDao.save(userTwo);

//
        departmentDao.addUserToDepartment(testDepartment,userOne);
        departmentDao.addUserToDepartment(testDepartment,userTwo);

        Users[] users={userOne,userTwo};
        assertEquals(1,departmentDao.getAll().size());
        assertEquals(2,userDao.getAll().size());
//        assertEquals(2,departmentDao.getAllUsersInDepartment().size());
//      assertEquals(Arrays.asList(users),departmentDao.getAllUsersInDepartment().size());
    }

    //    HELPERS
    public Department createDepartment()
    {
        return new Department("Raw News","Second Floor");
    }
    public Users createUser()
    {
        return new Users("Linus","linus@qmail.com","0714719935",12345);
    }
    public Users createRoles()
    {
        return new Users(1,2,3,"Receive Calls","Secretary");
    }
}