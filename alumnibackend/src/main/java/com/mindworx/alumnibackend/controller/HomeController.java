package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = " ")
public class HomeController {
    
    @GetMapping("")
    public String home(){
        return "pages/index";
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
        return "pages/register";
    }

    @GetMapping("/sign-in")
    public String login(){
        return "pages/sign";
    }


    @GetMapping("/forgot-password")
    public String passwordrest(){
        return "pages/resetpassword";
    }

    
 
}
