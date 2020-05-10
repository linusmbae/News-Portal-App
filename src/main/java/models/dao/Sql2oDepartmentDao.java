package models.dao;

import models.Department;
import models.Users;
import org.sql2o.*;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(Department department) {
        String saveDepartment="INSERT INTO department (name,floor) VALUES (:name, :floor)";
        try(Connection conn = sql2o.open()) {
            int id =(int) conn.createQuery(saveDepartment, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void addUserToDepartment(Department department, Users users) {
        String sql ="INSERT INTO department_with_user(department_id, user_id, user_role, user_position) VALUES (:department_id, :user_id, :user_role, :user_position)";
        try(Connection conn=sql2o.open()) {
             conn.createQuery(sql)
                    .addParameter("department_id",department.getId())
                    .addParameter("user_id",users.getId())
                    .addParameter("user_role",users.getUserRole())
                    .addParameter("user_position",users.getUserPosition())
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM department WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public List<Department> getAllUsersInDepartment() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM department_with_user")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Users findUsersInDepartment(int userId) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM department_with_user WHERE user_id = :user_id")
                    .addParameter("user_id", userId)
                    .executeAndFetchFirst(Users.class);
        }
    }

    @Override
    public void update(int id, String newName, String newFloor) {
        String updateDepartment="UPDATE department SET name=:name,floor=:floor WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(updateDepartment)
                    .addParameter("name",newName)
                    .addParameter("floor",newFloor)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql ="DELETE FROM department WHERE id=:id";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql ="DELETE FROM department";
        String sql1 ="DELETE FROM department_with_user";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(sql)
                    .executeUpdate();

            conn.createQuery(sql1)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }
}
