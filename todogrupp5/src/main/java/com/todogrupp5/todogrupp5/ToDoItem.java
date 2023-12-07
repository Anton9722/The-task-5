package com.todogrupp5.todogrupp5;

import java.time.LocalDateTime;

public class ToDoItem {
    private String toDoItemName;
    private LocalDateTime timeNow;
    private String deadline;
    int id;
    public ToDoItem(String toDoItemName, LocalDateTime timeNow,int id, String deadline){
        this.toDoItemName = toDoItemName;
        this.timeNow = LocalDateTime.now();
        this.id = id;
        this.deadline = deadline;

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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
