package model;

public class Administrator extends User {

    public Administrator(String fullName, String password, String email, Rol rol) {
        super(fullName, password, email, rol);
    }

    @Override
    public void showProfile() {

    }
}
