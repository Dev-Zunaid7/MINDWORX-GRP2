package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.RegistrationRequest;
import com.mindworx.alumnibackend.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    // @GetMapping(path = "confirm")
    // public String confirm(@RequestParam("token") String token){
    //     return registrationService.confirmToken(token);
    // } 
}
