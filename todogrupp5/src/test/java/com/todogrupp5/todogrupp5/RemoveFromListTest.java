package com.todogrupp5.todogrupp5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RemoveFromListTest {
    

    @Test
    public void testRemoveFromList(){
        List<String> tasks = new ArrayList<>();
        tasks.add("Städa");
        tasks.add("Torka");
        tasks.add("Laga mat");
        assertEquals(3,tasks.size());
        assertEquals(2,Todogrupp5Application.removeFromList(tasks));
    }
}
