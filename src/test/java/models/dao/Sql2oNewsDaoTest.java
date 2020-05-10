package models.dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.*;


import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private static Connection conn;
    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "12345");
        System.out.println("Connection Initialized");
    }

    @After
    public void tearDown() throws Exception {
    }
}