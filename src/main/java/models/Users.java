package models;

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
}
