package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
    
    @GetMapping("/account/profile")
    public String updateUserProfile(Model model) {
        model.addAttribute("title", "Account Profile");
        return "pages/alumni/profile";
    }

    
    @GetMapping("/account/settings")
    public String getChangeSettings(Model model) {
        model.addAttribute("title", "Account Settings");
        return "pages/settings";
    }
}
