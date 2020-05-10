import com.google.gson.Gson;
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


    }
}
