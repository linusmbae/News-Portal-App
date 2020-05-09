package models.dao;

import models.Users;

import java.util.List;

public interface UserDao {
//    CREATE
    void save(Users users);

//    READ
    List<Users> getAll();
    Users findById(int id);

//    UPDATE

//    DELETE
    void clearAll();
    void removeById(int id);
}
