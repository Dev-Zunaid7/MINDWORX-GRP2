package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.RegistrationRequest;
import com.mindworx.alumnibackend.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/sign-up")
    public String register( @ModelAttribute("user") RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping
    public String showRegistrationPage(){
        return "pages/register";
    }


    // @GetMapping(path = "confirm")
    // public String confirm(@RequestParam("token") String token){
    //     return registrationService.confirmToken(token);
    // } 
}
