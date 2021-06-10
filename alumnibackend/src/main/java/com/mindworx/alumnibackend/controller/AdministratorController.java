package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministratorController {
    
    //only by admin
    @GetMapping("/admin")
    public String admin(){
        return "pages/adminboard";
    }
}
