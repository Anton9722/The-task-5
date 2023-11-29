package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username; 
    private String password;
    private List<ToDoList> lists;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.lists = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoList> getLists() {
        return lists;
    }

    public void setLists(List<ToDoList> lists) {
        this.lists = lists;
    }
    
}
