package com.todogrupp5.todogrupp5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    String getHomePage(Model model){
        return "index";
    }
}
