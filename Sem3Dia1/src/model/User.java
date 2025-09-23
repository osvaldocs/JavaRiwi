package model;

import java.util.Map;

public abstract class User {
    private String fullName;
    private String password;
    private String email;
    private String address;
    private String phone;
    private boolean active;
    protected Role role;

    //constructor para admin
    public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    //constructor para customer
    public User(String fullName, String password, String email, String address, String phone) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public abstract Map<String, String> getProfileFields();



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRol() {
        return role;
    }

    public void setRol(Role role) {
        this.role = role;
    }
}
