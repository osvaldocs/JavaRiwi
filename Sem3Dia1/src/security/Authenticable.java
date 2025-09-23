package security;

import model.User;

public interface Authenticable {
    public User authenticate(String email, String password);
}
