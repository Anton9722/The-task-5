package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username; 
    private String password;
    private boolean loggedIn;
    private List<UserList> lists;
    private int id;

    public User (String username, String password, boolean loggedIn, int id) {
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
        this.lists = new ArrayList<>();
        this.id = id;
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

    public List<UserList> getLists() {
        return lists;
    }

    public void setLists(List<UserList> lists) {
        this.lists = lists;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void logIn(){
        this.loggedIn = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
