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

    }

    @Override
    public void addUserToDepartment(Department department, Users users) {

    }

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Users> findUersInDepartment(int userId) {
        return null;
    }

    @Override
    public void update(int id, String name, String floor) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
