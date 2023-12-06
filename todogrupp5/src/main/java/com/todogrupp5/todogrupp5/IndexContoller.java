package com.todogrupp5.todogrupp5;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexContoller {

    @GetMapping("/")
    String getHomePage (Model model) {
        model.addAttribute("users", UserController.users);
        return "index";
    }

    @PostMapping("/")
    String login(@RequestParam("username") String username, @RequestParam("password") String password) {
    for (User user : UserController.users) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            user.setLoggedIn(true);
            return "redirect:/createuser";
        }
    }
    return "index";
}
    
@PostMapping("/logout")
String logout(@RequestParam(name = "loggedIn", defaultValue = "false") boolean loggedIn) {
    for (User user : UserController.users) {
        if (user.isLoggedIn()) {
            user.setLoggedIn(false);
            return "redirect:/";
        }
    }
    // Handle the case where the user is not found or not logged in
    return "redirect:/";
}
    
 
}

