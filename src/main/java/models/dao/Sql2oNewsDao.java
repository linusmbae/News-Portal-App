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
    public void saveNews(News news) {
        String saveDepartmentNews="INSERT INTO news (content,type)VALUES(:content,:type)";
        try(Connection conn=sql2o.open())
        {
            int id=(int)conn.createQuery(saveDepartmentNews)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void saveDepartmentNews(DepartmentNews departmentNews) {
        String saveDepartmentNews="INSERT INTO department_with_news (department_id,news_id) VALUES (:department_id,:news_id)";
        try(Connection conn=sql2o.open()) {
            int id=(int)conn.createQuery(saveDepartmentNews)
                    .bind(departmentNews)
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
        String saveGeneralNews="INSERT INTO department_with_news (department_id,news_id) VALUES (:department_id,:news_id)";
        try(Connection conn=sql2o.open()) {
            int id =(int)conn.createQuery(saveGeneralNews)
                    .bind(generalNews)
                    .executeUpdate()
                    .getKey();
            generalNews.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SEELECT *FROM department_with_news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public List<DepartmentNews> getDepartmentNews(int departmentNewsId) {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM department_with_news WHERE department_id=:departmentNewsId")
                    .addParameter("departmentNewsId",departmentNewsId)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public List<GeneralNews> getGeneralNews(int generalNewsId) {
        try(Connection conn=sql2o.open()) {
            return conn.createQuery("SELECT * FROM department_with_news WHERE department_id=:generalNewsId")
                    .addParameter("generalNewsId",generalNewsId)
                    .executeAndFetch(GeneralNews.class);
        }
    }

    @Override
    public void clearAll() {
        String news ="DELETE FROM news";
        String department_with_news ="DELETE FROM department_with_news";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(news)
                    .executeUpdate();

            conn.createQuery(department_with_news)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void removeById(int id,int department_id) {
        String sql ="DELETE FROM news WHERE id=:id";
        String sql1 ="DELETE FROM department_with_news WHERE department_id=:department_id";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();

            conn.createQuery(sql1)
                    .addParameter("department_id",department_id)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
