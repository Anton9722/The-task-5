package com.todogrupp5.todogrupp5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Todogrupp5ApplicationTests {

	@Test 
	public void loginSuccessTest () {
		String username = "user";
		String correctPassword = "correctpass";

		assertTrue(Todogrupp5Application.loginSuccess(username, correctPassword));
	}

	@Test
	public void loginFailTest () {
		String username = "wronguser";
		String password = "wrongpass";

		assertFalse(Todogrupp5Application.loginSuccess(username, password));
	}

	@Test
	public void addUserTest () {
		UserList toDoList = new UserList("UserList");
		User user = new User("user", "pass", false);

		toDoList.addUser(user);

		assertEquals(1,toDoList.getUsers().size());
		assertEquals("user", toDoList.getUsers().get(0).getUsername());
	}

	@Test
    public void testDeadline(){
        ToDoItem task = new ToDoItem("Städa",LocalDateTime.now());
        String dateTime = "2023-12-08T11:45";
        LocalDateTime deadline = LocalDateTime.parse(dateTime);
        assertEquals(deadline,Todogrupp5Application.deadLine(task.getCurrentDateTime()));
       
    }
    @Test
    public void testRemoveFromList(){
        List<String> tasks = new ArrayList<>();
        tasks.add("Städa");
        tasks.add("Torka");
        tasks.add("Laga mat");
        assertEquals(3,tasks.size());
    }
	@Test
public void testlogIn(){
    List<User> users = new ArrayList<>();
    users.add(new User("Sam","123!Sam",false));
    users.add(new User("Sanna","123!Sanna",false));
    users.add(new User("Anton","123!Anton",false));
    users.add(new User("Marcus","123!Marcus",false));
    users.add(new User("Georg","123!Georg",false));

    assertEquals("Sam"+"123!Sam",Todogrupp5Application.logIn(users, "Sam", "123!Sam"));
}
    @Test
    public void testLogOut(){
	    boolean isLoggedOut = true;
	    User User = new User("","",false);
	    assertEquals(isLoggedOut, Todogrupp5Application.logOut(User));
}
    


}
 
