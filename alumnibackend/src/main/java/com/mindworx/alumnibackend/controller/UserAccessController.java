package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccessController {
   
    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "pages/error/errorforbidden";
    } 
}
