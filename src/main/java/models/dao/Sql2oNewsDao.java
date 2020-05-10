package models.dao;

import models.DepartmentNews;
import models.GeneralNews;
import models.News;
import org.sql2o.*;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void saveDepartmentNews(DepartmentNews departmentNews) {
        String saveDepartmentNews="INSERT INTO news (content,type)VALUES(:content,:type)";
        try(Connection conn=sql2o.open()) {
            int id=(int)conn.createQuery(saveDepartmentNews,true)
                    .addParameter("content",departmentNews.getContent())
                    .addParameter("type",departmentNews.getType())
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void saveGeneralNews(GeneralNews generalNews) {
        String saveGeneralNews="INSERT INTO news (content,type)VALUES(:content,:type)";
        try(Connection conn=sql2o.open()) {
            int id =(int)conn.createQuery(saveGeneralNews,true)
                    .addParameter("content",generalNews.getContent())
                    .addParameter("type",generalNews.getType())
                    .executeUpdate()
                    .getKey();
            generalNews.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM news")
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public List<GeneralNews> getAllGeneralNews() {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM news")
                    .executeAndFetch(GeneralNews.class);
        }
    }

    @Override
    public List<DepartmentNews> getDepartmentNews(DepartmentNews departmentNews) {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM news WHERE type=:type")
                    .addParameter("type",departmentNews.getType())
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public List<GeneralNews> getGeneralNews(GeneralNews generalNews) {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM news WHERE type=:type")
                    .addParameter("generalNewsId",generalNews.getType())
                    .executeAndFetch(GeneralNews.class);
        }
    }

    @Override
    public void clearAll() {
        String news ="DELETE FROM news";
//        String department_with_news ="DELETE FROM department_with_news";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(news)
                    .executeUpdate();

//            conn.createQuery(department_with_news)
//                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void removeById(int id) {
        String sql ="DELETE FROM news WHERE id=:id";
//        String sql1 ="DELETE FROM department_with_news WHERE department_id=:department_id";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();

//            conn.createQuery(sql1)
//                    .addParameter("department_id",department_id)
//                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
