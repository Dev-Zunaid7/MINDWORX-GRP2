package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministratorController {
    
    //only by admin
    @GetMapping("/account/admin")
    public String admin(Model model){
        model.addAttribute("title", "Admin");
        return "pages/adminboard";
    }
}
