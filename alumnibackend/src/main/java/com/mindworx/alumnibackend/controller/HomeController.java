package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = " ")
public class HomeController {
    
    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/alumni")
    public String user(){
        return ("<h1>Welcome Alumni</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Administrator</h1>");
    }

    @GetMapping("/coach")
    public String coach(){
        return ("<h1>Welcome Coach</h1>");
    }

    @GetMapping("/sign-up")
    public String register(){
        return "Registration";
    }

    @GetMapping("/sign-in")
    public String login(){
        return "Signin";
    }

 
}
