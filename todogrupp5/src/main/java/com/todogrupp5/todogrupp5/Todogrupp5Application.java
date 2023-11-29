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

    public static Object logIn(List<User> users) {
        return null;
    }

    public static Object logOut(User user) {
        return null;
    }
	
}
