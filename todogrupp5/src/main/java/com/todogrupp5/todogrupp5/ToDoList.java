package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private String listName;
    private List<User> users;
    
    public ToDoList(String listName) {
        this.listName = listName;
        this.users = new ArrayList<>();
    }

    public void addUser (User user) {
        this.users.add(user);
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
}
