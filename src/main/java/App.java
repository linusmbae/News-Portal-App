import com.google.gson.Gson;
import models.Department;
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
            userDao.removeById(users.getId());
            response.status(201);
            return gson.toJson(users);
        });

//
//        FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
