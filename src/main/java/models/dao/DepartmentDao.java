package models.dao;

import models.Department;
import models.Users;

import java.util.List;

public interface DepartmentDao {
//    CREATE
    void save(Department department);
    void addUserToDepartment(Department department, Users users);


//    READ
    List<Department> getAll();
    Department findById(int id);

    List<Department>getAllUsersInDepartment();
    Users findUsersInDepartment(int userId);

//    UPDATE
    void update(int id,String name, String floor);

//    DELETE
    void deleteById(int id);
    void clearAll();
}
