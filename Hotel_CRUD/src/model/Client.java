package model;

public class Client {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    public Client(int id, String name, String lastName, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
}
