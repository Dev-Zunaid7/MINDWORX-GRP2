package com.mindworx.alumnibackend.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserAccessController {
   
    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "pages/error/errorforbidden";
    } 
}
