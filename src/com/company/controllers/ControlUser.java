package com.company.controllers;

import com.company.models.User;

import java.util.ArrayList;

public class ControlUser {

    ArrayList<User> users;

    public ControlUser() {
        users = new ArrayList<>();
    }

    //create
    public boolean add(User user) {
        if (!exists(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public int generateID() {
        if (users.size() == 0) {
            return 0;
        } else {
            return get(users.size()-1).getId() + 1;
        }
    }

    //read
    public boolean exists(User user) {
        return users.contains(user);
    }
    public User get(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    //update
    public boolean set(int id, User user) {
        int c = 0;
        for (User u : users) {
            if (u.getId() == id) {
                users.set(c, user);
                return true;
            }
            c++;
        }
        return false;
    }

    //delete
    public boolean remove(User user) {
        if (exists(user)) {
            users.remove(user);
            return true;
        } else {
            return false;
        }
    }

}
