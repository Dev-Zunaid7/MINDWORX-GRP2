package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "pages/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
    
        return "pages/login";
    }

    @GetMapping("/FAQ")
    public String getMethodName() {
        
        return "pages/chatbox";
    }
    

}
