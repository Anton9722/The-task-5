package com.todogrupp5.todogrupp5;

import java.util.ArrayList;

public class ToDoList {
    
    ArrayList<ToDoItem> toDoItems;
    private String listName;
    int id;
    
    ToDoList (String listName,int id){
       
        this.toDoItems = new ArrayList<>();
        this.listName = listName;
        this.id = id;
        
       
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public ArrayList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(ArrayList<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
