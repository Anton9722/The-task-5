package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    static final List<User> users = new ArrayList<>();
    static{
        users.add(new User("admin", "admin", false, 1));
    }

    // Skapa Användare
    @GetMapping("/createuser")
    public String getUser(Model model, String username, String password){
        model.addAttribute("users", new User("", "", false, 0));
        model.addAttribute("users", users);
        return "createuser";
    }

    // Lägg till Användare
    @PostMapping("/addUser")
    public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Lösenorden matchar inte. Vänligen försök igen.");
            return "createuser";
        }
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("error", "Användarnamnet är redan taget. Vänligen välj ett annat.");
                return "createuser";
            }
        }
        users.add(new User(username, password, false, users.size() + 1));
        System.out.println("Postmapping addUser: " + username + " " + password);
        return "redirect:/createuser";
    }

    // Ta bort Användare
    @GetMapping("/remove-user/{userId}")
    public String removeUser(@PathVariable int userId){
        User userToRemove = users.stream()
            .filter(user -> user.getId() == userId)
            .findFirst()
            .orElse(null);
        if (userToRemove != null) {
            System.out.println("Removing User : " + userId + ", Username: " + userToRemove.getUsername());
            users.remove(userToRemove);
        }
            return "redirect:/createuser";
    }


}
