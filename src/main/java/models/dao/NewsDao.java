package models.dao;

import models.DepartmentNews;
import models.GeneralNews;
import models.News;

import java.util.List;

public interface NewsDao {
//    CREATE
    void saveDepartmentNews(DepartmentNews departmentNews);
    void saveGeneralNews(GeneralNews generalNews);


//    READ
    List<News>getAll();
    List<DepartmentNews> getDepartmentNews(int departmentNewsId);
    List<GeneralNews>getGeneralNews(int generalNewsId);


//    UPDATE

//    DELETE
    void clearAll();
    void removeById(int id);

}
