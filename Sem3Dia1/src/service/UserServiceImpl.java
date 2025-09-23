package service;

import model.Customer;
import model.User;
import security.Authenticable;

import java.util.ArrayList;
import java.util.List;

import static utils.Validators.*;

public class UserServiceImpl implements  UserService, Authenticable {

    private final List<User> users = new ArrayList<>();

    @Override
    public User authenticate(String email, String password) {
        List<User> allUsers = getAllUsers();
        for (User u : allUsers) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public User createUser(String fullName, String password, String email, String address, String phone) {
        if (!stringValidator(fullName)) {
            throw new IllegalArgumentException ("Invalid input");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException ("Invalid input");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException ("Invalid input");
        }
        if (!stringValidator(address)) {
            throw new IllegalArgumentException ("Invalid input");
        }
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException ("Invalid input");
        }
        return new Customer(fullName, password, email, address, phone);
    }
}
