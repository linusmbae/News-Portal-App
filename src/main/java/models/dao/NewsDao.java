package models.dao;

import models.DepartmentNews;
import models.GeneralNews;
import models.News;

import java.util.List;

public interface NewsDao {
//    CREATE
//    void saveNews(News news);
    void saveDepartmentNews(DepartmentNews departmentNews);
    void saveGeneralNews(GeneralNews generalNews);


//    READ
    List<DepartmentNews>getAllDepartmentNews();
    List<GeneralNews>getAllGeneralNews();
    List<DepartmentNews> getDepartmentNews(DepartmentNews departmentNews);
    List<GeneralNews>getGeneralNews(GeneralNews generalNews);


//    UPDATE

//    DELETE
    void clearAll();
    void removeById(int id);

}
