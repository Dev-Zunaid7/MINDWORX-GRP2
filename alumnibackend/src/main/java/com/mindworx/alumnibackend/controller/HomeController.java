package com.mindworx.alumnibackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
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

 
}
