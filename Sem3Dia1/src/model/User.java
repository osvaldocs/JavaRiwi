package model;

public abstract class User {
    private String fullName;
    private String password;
    private String email;
    private String adress;
    private int phone;
    private boolean active;
    private Rol rol;

    public User(String fullName, String password, String email, Rol rol) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public User(String fullName, String password, String email, String adress, int phone, Rol rol) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.phone = phone;
        this.rol = rol;
    }

    public abstract void showProfile();


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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
