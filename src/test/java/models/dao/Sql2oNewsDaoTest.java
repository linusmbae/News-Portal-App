package models.dao;

import models.DepartmentNews;
import models.GeneralNews;
import models.News;
import org.junit.*;
import org.sql2o.*;


import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private static Connection conn;
    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentDao departmentDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "12345");
        System.out.println("Connection Initialized");
        newsDao=new Sql2oNewsDao(sql2o);
        departmentDao=new Sql2oDepartmentDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clear Database");
        newsDao.clearAll();
        departmentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception
    {
        conn.close();
        System.out.println("Connection Closed");
    }

    @Test
    public void save_savesDepartmentNews()throws Exception {
        DepartmentNews departmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(departmentNews);
        News[] news={departmentNews};
        assertEquals(Arrays.asList(news),newsDao.getDepartmentNews(departmentNews));
    }

    @Test
    public void save_savesGeneralNews()throws Exception {
        GeneralNews generalNews=createGeneralNews();
        newsDao.saveGeneralNews(generalNews);
        News[] news ={generalNews};
        assertEquals(Arrays.asList(news),newsDao.getGeneralNews(generalNews));
    }

    @Test
    public void getDepartmentNews_returnsNewsInstancesById()throws Exception {
        DepartmentNews departmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(departmentNews);
        DepartmentNews secondDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(secondDepartmentNews);
        DepartmentNews thirdDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(thirdDepartmentNews);

        News[]news={departmentNews,secondDepartmentNews,thirdDepartmentNews};

        assertEquals(Arrays.asList(news[2]),newsDao.getDepartmentNews(thirdDepartmentNews));
    }

    @Test
    public void getGeneralNews_returnsNewsInstanceById()throws Exception {
        GeneralNews generalNews=createGeneralNews();
        newsDao.saveGeneralNews(generalNews);
        GeneralNews generalNews1=createGeneralNews();
        newsDao.saveGeneralNews(generalNews1);
        GeneralNews generalNews2=createGeneralNews();
        newsDao.saveGeneralNews(generalNews2);

        News[]news={generalNews,generalNews1,generalNews2};
        assertEquals(Arrays.asList(news[2]),newsDao.getGeneralNews(generalNews2));
    }

    @Test
    public void removeById_clearsGeneralNewsInstanceById()throws Exception {
        GeneralNews generalNews=createGeneralNews();
        newsDao.saveGeneralNews(generalNews);
        GeneralNews generalNews1=createGeneralNews();
        newsDao.saveGeneralNews(generalNews1);
        GeneralNews generalNews2=createGeneralNews();
        newsDao.saveGeneralNews(generalNews2);

        assertEquals(3,newsDao.getAllGeneralNews().size());

        newsDao.removeById(generalNews1.getId());
        assertEquals(2,newsDao.getAllGeneralNews().size());
    }

    @Test
    public void getAllDepartmentNews_returnsCorrectSize()throws Exception {
        DepartmentNews departmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(departmentNews);
        DepartmentNews secondDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(secondDepartmentNews);
        DepartmentNews thirdDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(thirdDepartmentNews);

        assertEquals(3,newsDao.getAllDepartmentNews().size());
    }

    @Test
    public void getAllGeneralNews_returnsCorrectSize()throws Exception {
        GeneralNews generalNews=createGeneralNews();
        newsDao.saveGeneralNews(generalNews);
        GeneralNews generalNews1=createGeneralNews();
        newsDao.saveGeneralNews(generalNews1);
        GeneralNews generalNews2=createGeneralNews();
        newsDao.saveGeneralNews(generalNews2);

        assertEquals(3,newsDao.getAllGeneralNews().size());
    }

    @Test
    public void removeById_clearsDepartmentNewsById()throws Exception {
        DepartmentNews departmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(departmentNews);
        DepartmentNews secondDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(secondDepartmentNews);
        DepartmentNews thirdDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(thirdDepartmentNews);

        assertEquals(3,newsDao.getAllDepartmentNews().size());

        newsDao.removeById(thirdDepartmentNews.getId());
        assertEquals(2,newsDao.getAllDepartmentNews().size());
    }

    @Test
    public void clearAll_EmptiesAllDepartmentInstances()throws Exception {
        DepartmentNews departmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(departmentNews);
        DepartmentNews secondDepartmentNews=createDepartmentNews();
        newsDao.saveDepartmentNews(secondDepartmentNews);
        assertEquals(2,newsDao.getAllDepartmentNews().size());

        newsDao.clearAll();
        assertEquals(0,newsDao.getAllDepartmentNews().size());
    }

    @Test
    public void clearAll_clearsAllGeneralNewsInstances()throws Exception {
        GeneralNews generalNews=createGeneralNews();
        newsDao.saveGeneralNews(generalNews);
        GeneralNews generalNews1=createGeneralNews();
        newsDao.saveGeneralNews(generalNews1);
        GeneralNews generalNews2=createGeneralNews();
        newsDao.saveGeneralNews(generalNews2);

        assertEquals(3,newsDao.getAllGeneralNews().size());

        newsDao.clearAll();
        assertEquals(0,newsDao.getAllGeneralNews().size());
    }

    //    HELPERS
    public DepartmentNews createDepartmentNews()
    {
        return new DepartmentNews("Tomorrow Is A Public Holiday");
    }

    public GeneralNews createGeneralNews()
    {
        return new GeneralNews("We will have department shifts the coming week");
    }
}