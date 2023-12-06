package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexContoller {
    private static final List <User> userList = new ArrayList<>();

    @GetMapping("/")
    String getHomePage (Model model) {
        return "index";
    }

    @PostMapping("/")
    String login(@RequestParam("username") String username, @RequestParam ("password") String password){
        if (username.equals("admin") && password.equals("admin")) {
            return "redirect:/createuser";
        } else {
            return "index";
        }
    }
    
    @PostMapping("/logout")
    String logout(Model model) {
        userList.clear();
        return "redirect:/";
    }
}

