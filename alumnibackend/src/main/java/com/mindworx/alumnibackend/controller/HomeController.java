package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
     @GetMapping("/")
    public String home(){
        
        return "pages/index";
    }

    @GetMapping("/login")
    public String login(){
      return "pages/login";
    }

    //only by user
    @GetMapping("/home")
    public String feed(Model model){
        return ("<h1>Welcome to the feeds page<h1>");
    }
        
    //only by admin
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome to the administrator dashboard<h1>");
    }
    
    //only by coach
    @GetMapping("/coach")
    public String coach(){
        return ("<h1>Welcome to the coach dashboard<h1>");
    }

    @GetMapping("/forgot-password")
    public String passwordrest(){
        return "pages/resetpassword";
    }


}

   
