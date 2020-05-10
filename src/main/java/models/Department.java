package models;

import java.util.Objects;

public class Department {
private int id;
private String name;
private String floor;
;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return  Objects.equals(name, that.name) &&
                Objects.equals(floor, that.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, floor);
    }
}
