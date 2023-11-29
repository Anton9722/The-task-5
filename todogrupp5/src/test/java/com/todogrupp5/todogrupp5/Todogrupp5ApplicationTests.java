package com.todogrupp5.todogrupp5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.config.Task;

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
		ToDoList toDoList = new ToDoList("UserList");
		User user = new User("user", "pass");

		toDoList.addUser(user);

		assertEquals(1,toDoList.getUsers().size());
		assertEquals("user", toDoList.getUsers().get(0).getUsername());
	}

	// @Test
	// public void createToDoListTest() {
	// 	ToDoList todolist = new ToDoList("List");
	// 	assertEquals("List", todolist.getListName());

	
	//Georg's tester
	@Test
    public void testDeadline(){
        Task task = new Task("Städa",LocalDateTime.now());
        String dateTime = "2023-12-08T11:45";
        LocalDateTime deadline = LocalDateTime.parse(dateTime);
        assertEquals(deadline,App.deadLine2(task.getCurrentDateTime()));
       
    }
    @Test
    public void testRemoveFromList(){
        List<String> tasks = new ArrayList<>();
        tasks.add("Städa");
        tasks.add("Torka");
        tasks.add("Laga mat");
        assertEquals(3,tasks.size());
        assertEquals(2,App.removeFromList(tasks));
    }
	@Test
    public void testlogIn(){
        List<Member> members = new ArrayList<>();
        members.add(new Member("Sam","123!Sam",false));
        members.add(new Member("Sanna","123!Sanna",false));
        members.add(new Member("Anton","123!Anton",false));
        members.add(new Member("Marcus","123!Marcus",false));
        members.add(new Member("Georg","123!Georg",false));
      
        
        assertEquals("Sam"+"123!Sam",App.logIn(members));

 }  
    @Test
    public void testLogOut(){
	    boolean isLoggedOut = true;
	    Member member = new Member("","",false);
	    assertEquals(isLoggedOut, App.logOut(member));
}
    //slut av Georg's tester


}
 
