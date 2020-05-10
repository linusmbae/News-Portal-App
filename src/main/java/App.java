import com.google.gson.Gson;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Users;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oNewsDao;
import models.dao.Sql2oUserDao;
import org.sql2o.*;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson=new Gson();

        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database";
        Sql2o sql2o = new Sql2o(connectionString, "linus", "mariano@9496");
        departmentDao=new Sql2oDepartmentDao(sql2o);
        newsDao=new Sql2oNewsDao(sql2o);
        userDao=new Sql2oUserDao(sql2o);
        conn=sql2o.open();

//        USERS
        post("/users/new","application/json",(request, response) ->
        {
            Users users=gson.fromJson(request.body(),Users.class);
            userDao.save(users);
            response.status(201);
            return gson.toJson(users);
        });

        get("/users","application/json",(request, response) ->
        {
            System.out.println(userDao.getAll());
            if (userDao.getAll().size()>0)
            {
                return gson.toJson(userDao.getAll());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no users are currently listed in the database.\\\"}";
            }
        });

        get("/users/:id","application/json",(request, response) ->
        {
           int userId=Integer.parseInt(request.params("id"));
           Users findUser=userDao.findById(userId);
           if (findUser!=null)
           {
               return gson.toJson(findUser);
           }else
           {
               return "{\\\"message\\\":\\\"I'm sorry, but no users are currently listed in the database.\\\"}";
           }
        });

        post("/users/:id/remove","application/json",(request, response) ->
        {
            int userId=Integer.parseInt(request.params("id"));
            Users users=userDao.findById(userId);
            if (users!=null)
            {
                userDao.removeById(users.getId());
                return gson.toJson(departmentDao.getAll());
            }else
            {
                return gson.toJson(departmentDao.getAll());
            }

        });

        post("/users/clear","application/json",(request, response) ->
        {
            System.out.println(userDao.getAll());
            if (userDao.getAll().size()>0)
            {
                userDao.clearAll();
                return gson.toJson(userDao.getAll());
            }else
            {
                return gson.toJson(userDao.getAll());
            }
        });

//        DEPARTMENT
        post("/department/new","application/json",(request, response) ->
        {
            Department department=gson.fromJson(request.body(),Department.class);
            departmentDao.save(department);
            response.status(201);
            return gson.toJson(department);
        });

        get("/departments","application/json",(request, response) ->
        {
            System.out.println(departmentDao.getAll());
            if (departmentDao.getAll().size()>0) {
                return gson.toJson(departmentDao.getAll());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no departments are currently listed in the database.\\\"}";
            }
        });

        get("/department/:id","application/json",(request, response) ->
        {
            int departmentId=Integer.parseInt(request.params("id"));
            Department findDepartment=departmentDao.findById(departmentId);
            if (findDepartment!=null)
            {
                return gson.toJson(findDepartment);
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no departments are currently listed in the database.\\\"}";
            }
        });

//        post("department/:id/update","application.json",(request, response) ->
//        {
//            int departmentId=Integer.parseInt(request.params("id"));
//            Department findDepartment=departmentDao.findById(departmentId);
//
//
//            if (findDepartment!=null)
//            {
//                departmentDao.update();
//
//            }
//        });

        post("/departments/:id/remove","application/json",(request, response) ->
        {
            System.out.println(departmentDao.getAll());
            int departmentId=Integer.parseInt(request.params("id"));
            Department departmentToRemove=departmentDao.findById(departmentId);
            if (departmentToRemove!=null) {
                departmentDao.deleteById(departmentToRemove.getId());
                return gson.toJson(departmentDao.getAll());
            }else
            {
                return gson.toJson(departmentDao.getAll());
            }
        });
        post("/departments/remove/all","application/json",(request, response) ->
        {
            System.out.println(departmentDao.getAll());
            if (departmentDao.getAll().size()>0) {
                departmentDao.clearAll();
                return gson.toJson(departmentDao.getAll());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no departments are currently listed in the database.\\\"}";
            }
        });

//        NEWS (GENERAL)
        post("/news/general-news/new","application/json",(request, response) ->
        {
            GeneralNews generalNews=gson.fromJson(request.body(),GeneralNews.class);
            newsDao.saveGeneralNews(generalNews);
            response.status(201);
            return gson.toJson(generalNews);
        });

        get("/news/general-news/","application.json",(request, response) ->
        {
            System.out.println(newsDao.getAllGeneralNews());
            if (newsDao.getAllGeneralNews().size()>0)
            {
                return gson.toJson(newsDao.getAllGeneralNews());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no news are currently listed in the database.\\\"}";

            }
        });

//        get("/news/general-news/:id","application.json",(request, response) ->
//        {
//            int newsId=Integer.parseInt(request.params("id"));
//            GeneralNews generalNews=newsDao.getGeneralNews(newsId);
//        });

        post("/news/general-news/clear","application/json",(request, response) ->
        {
            System.out.println(newsDao.getAllGeneralNews());
            if (newsDao.getAllGeneralNews().size()>0)
            {
                newsDao.clearAll();
                return gson.toJson(newsDao.getAllGeneralNews());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no news are currently listed in the database.\\\"}";
            }
        });

//        DEPARTMENT NEWS
        post("/news/department-news/new","application/json",(request, response) ->
        {
            DepartmentNews departmentNews=gson.fromJson(request.body(),DepartmentNews.class);
            newsDao.saveDepartmentNews(departmentNews);
            response.status(201);
            return gson.toJson(departmentNews);
        });

        get("/news/department-news","application/json",(request, response) ->
        {
            System.out.println(newsDao.getAllDepartmentNews());
            if (newsDao.getAllDepartmentNews().size()>0)
            {
                return gson.toJson(newsDao.getAllDepartmentNews());
            }else
            {
                return "{\\\"message\\\":\\\"I'm sorry, but no news are currently listed in the database.\\\"}";
            }
        });
        post("/news.department-news/clear","application/json",(request, response) ->
        {
            System.out.println(newsDao.getAllDepartmentNews());
            if (newsDao.getAllDepartmentNews().size()>0)
            {
                newsDao.clearAll();
                return gson.toJson(newsDao.getAllDepartmentNews());
            }else
            {
                return "{\\\"message\\\":\\\"database cleared\\\"}";
            }
        });
//        FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
