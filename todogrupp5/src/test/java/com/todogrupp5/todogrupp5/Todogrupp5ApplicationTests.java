package com.todogrupp5.todogrupp5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

 }
