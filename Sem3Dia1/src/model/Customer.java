package model;

public class Customer extends User {

    public Customer(String fullName, String password, String email, String adress, int phone, Rol rol) {
        super(fullName, password, email, adress, phone, rol);
    }

    @Override
    public void showProfile() {

    }
}
