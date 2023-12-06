package com.todogrupp5.todogrupp5;

import java.time.LocalDateTime;
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

	public static LocalDateTime deadLine(LocalDateTime currentDateTime, LocalDateTime deadline) {
		if (currentDateTime.isBefore(deadline)) {
			return deadline;
		} else {
			return null;
		}
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

	public static boolean logOut(User user) {
		if (user == null) {
			return false;
		}
		user.setLoggedIn(false);
		return true;
    }
	
}
