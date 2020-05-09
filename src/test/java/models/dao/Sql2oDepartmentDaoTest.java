package models.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sql2o.*;


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
}