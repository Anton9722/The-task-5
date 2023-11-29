package com.todogrupp5.todogrupp5;

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
	
}
