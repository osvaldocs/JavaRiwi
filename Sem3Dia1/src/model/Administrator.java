package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Administrator extends User {

    public Administrator(String fullName, String password, String email) {
        super(fullName, password, email);
        this.role = Role.ADMIN;
    }

    @Override
    public Map<String, String> getProfileFields() {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("Name", getFullName());
        data.put("Email", getEmail());
        data.put("Role", role.toString());
        return data;
    }


}
