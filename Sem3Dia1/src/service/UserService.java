package service;

import model.User;

import java.util.List;

public interface UserService {

    public void createUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(User user);
    public User createUser(String fullName, String password, String email, String address, String phone);
}
