package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResetPasswordController {
    

    //display page
    @GetMapping("/forgot-password")
    public String passwordrest(){
        return "pages/resetpassword";
    }

    //retrive the email for confirmation of existing account
    //
    
}
