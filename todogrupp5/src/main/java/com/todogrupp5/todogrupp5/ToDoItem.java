package com.todogrupp5.todogrupp5;

import java.time.LocalDateTime;

public class ToDoItem {
    private String toDoItemName;
    private LocalDateTime timeNow;
    int id;
    public ToDoItem(String toDoItemName, LocalDateTime timeNow,int id){
        this.toDoItemName = toDoItemName;
        this.timeNow = LocalDateTime.now();
        this.id = id;

    }
    public String getToDoItemName() {
        return toDoItemName;
    }
    public void setToDoItemName(String toDoItemName) {
        this.toDoItemName = toDoItemName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDateTime getTimeNow() {
        return timeNow;
    }
    public void setTimeNow(LocalDateTime timeNow) {
        this.timeNow = timeNow;
    }
    
}
