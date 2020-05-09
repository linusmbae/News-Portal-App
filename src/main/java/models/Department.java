package models;

import java.util.Objects;

public class Department {
private int id;
private String name;
private String floor;
private int newsId;
private int userId;
private String userRole;
private String userPosition;

    public Department(String name, String floor) {
        this.name = name;
        this.floor = floor;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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
        Department that = (Department) o;
        return newsId == that.newsId &&
                userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(userRole, that.userRole) &&
                Objects.equals(userPosition, that.userPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, floor, newsId, userId, userRole, userPosition);
    }
}
