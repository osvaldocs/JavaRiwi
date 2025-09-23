package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Customer extends User {


    public Customer(String fullName, String password, String email, String address, String phone) {
        super(fullName, password, email, address, phone);
        this.role = Role.CUSTOMER;
    }

    @Override
    public Map<String, String> getProfileFields() {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("Name", getFullName());
        data.put("Email", getEmail());
        data.put("Address", getAddress());
        data.put("Phone", String.valueOf(getPhone()));
        data.put("Role", role.toString());
        return data;
    }



}
