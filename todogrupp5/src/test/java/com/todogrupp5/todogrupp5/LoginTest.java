package com.todogrupp5.todogrupp5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LoginTest {
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
    public void testlogIn(){
        List<User> users = new ArrayList<>();
        users.add(new User("Sam","123!Sam",false, 0));
        users.add(new User("Sanna","123!Sanna",false, 1));
        users.add(new User("Anton","123!Anton",false, 2));
        users.add(new User("Marcus","123!Marcus",false, 3));
        users.add(new User("Georg","123!Georg",false, 4));
    
        assertEquals("Sam"+"123!Sam",Todogrupp5Application.logIn(users, "Sam", "123!Sam"));
    }
    @Test
    public void testLogOut(){
        User user = new User("","",false, 0);
        Boolean result = Todogrupp5Application.logOut(user);
        assertNotNull(result);
        assertTrue(result);
    }
}
