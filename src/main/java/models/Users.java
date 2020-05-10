package models;

import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int idNumber;
    private int  departmentId;
    private int newsId;
    private int userId;
    private String userRole;
    private String userPosition;

    public Users(String name, String email, String phone, int idNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idNumber = idNumber;
    }

    public Users(int  departmentId,int newsId, int userId, String userRole, String userPosition) {
        this.departmentId=departmentId;
        this.newsId = newsId;
        this.userId = userId;
        this.userRole = userRole;
        this.userPosition = userPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) &&
                Objects.equals(email, users.email) &&
                Objects.equals(phone, users.phone) &&
                Objects.equals(idNumber, users.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, idNumber);
    }
}
