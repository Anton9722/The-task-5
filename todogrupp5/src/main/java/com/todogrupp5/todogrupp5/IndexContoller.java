package com.todogrupp5.todogrupp5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexContoller {

    @GetMapping("/")
    String getHomePage(Model model, HttpSession session) {
        model.addAttribute("users", UserController.users);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser") != null);
        return "index";
    }

    @PostMapping("/logout")
    String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/")
    String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean userFound = UserController.users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));

        if (userFound) {
            session.setAttribute("loggedInUser", true);
            return "redirect:/";
        } else {
            model.addAttribute("loginError", true);
            return "index";
        }
    }
}
