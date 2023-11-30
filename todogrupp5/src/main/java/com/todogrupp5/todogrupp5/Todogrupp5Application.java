package com.todogrupp5.todogrupp5;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Todogrupp5Application {

	public static void main(String[] args) {
		SpringApplication.run(Todogrupp5Application.class, args);
	}

	public static boolean loginSuccess(String username, String password) {
		return username.equals("user") && password.equals("correctpass");
	}

	public static boolean loginFail(String username, String password) {
		return !loginSuccess(username, password);
		
	}

	public static Object deadLine(Object currentDateTime) {
		return null;
	}

	public static Integer removeFromList(List<String> tasks) {
		return null;
	}

    public static String logIn(List<User> users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user.getUsername() + user.getPassword();
			}
		}
		return null; // returnera null om användaren inte hittades eller lösenordet var felaktigt
	}

    public static Object logOut(User user) {
        return null;
    }
	
}
