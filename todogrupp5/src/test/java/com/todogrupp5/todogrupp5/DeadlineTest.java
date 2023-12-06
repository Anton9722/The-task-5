package com.todogrupp5.todogrupp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void testDeadline(){
        ToDoItem task = new ToDoItem("Städa", LocalDateTime.now(), 0);
        String dateTime = "2023-12-08T11:45";
        LocalDateTime deadline = LocalDateTime.parse(dateTime);
        assertEquals(deadline, Todogrupp5Application.deadLine(task.getTimeNow(), deadline));
    }
}
