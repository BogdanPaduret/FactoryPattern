package com.company.models;

import com.company.exceptions.InvalidUserTypeException;

public class UserSimpleFactory {
    public User createUser(String type, int id, String name) throws InvalidUserTypeException{
        User user = null;
        switch (type) {
            case "admin":
                user = new Admin(id, name);
                break;
            case "client":
                user = new Client(id, name);
                break;
            default:
                throw new InvalidUserTypeException("User does not exist");
        }
        return user;
    }
}
