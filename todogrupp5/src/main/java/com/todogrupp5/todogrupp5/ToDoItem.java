package com.todogrupp5.todogrupp5;

import java.time.LocalDateTime;

public class ToDoItem {
    private String toDo;
    private LocalDateTime deadline;
    public ToDoItem(String toDo, LocalDateTime deadline){
        this.toDo = toDo;
        this.deadline = deadline;

    }
    public String getToDo() {
        return toDo;
    }
    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
    public LocalDateTime getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public Object getCurrentDateTime() {
        return null;
    }
}
