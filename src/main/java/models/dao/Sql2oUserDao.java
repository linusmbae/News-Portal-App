package models.dao;

import models.Users;
import org.sql2o.*;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(Users users) {
        String saveUser = "INSERT INTO users (name, email,phone, idnumber) VALUES (:name, :email, :phone, :idNumber)";
        try(Connection conn=sql2o.open()) {
            int id=(int) conn.createQuery(saveUser,true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public List<Users> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public  Users findById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }
    }



    @Override
    public void clearAll() {
        String sql ="DELETE FROM users";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void removeById(int id) {
        String sql ="DELETE FROM users WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
