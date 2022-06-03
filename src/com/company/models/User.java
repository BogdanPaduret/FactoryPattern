package com.company.models;

import static com.company.helpers.Constants.*;

public class User implements Comparable<User>{

    private String type;
    private int id;
    private String name;

    public User(String type, int id, String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return this.getType().equals(user.getType()) &&
                this.getId() == user.getId() &&
                this.getName().equals(user.getName());
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getName() + SEPARATOR;
        string += this.getType() + SEPARATOR;
        string += this.getId();
        return string;
    }

    @Override //name comparison
    public int compareTo(User o) {
        return o.getName().compareTo(this.getName());
    }

}
