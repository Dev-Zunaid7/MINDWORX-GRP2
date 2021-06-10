package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "pages/index";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    // only by user
    @GetMapping("/home")
    public String feed(Model model) {
        return "pages/feeds";
    }

}
