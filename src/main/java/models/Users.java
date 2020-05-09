package models;

import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String idNumber;

    public Users(String name, String email, String phone, String idNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idNumber = idNumber;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
