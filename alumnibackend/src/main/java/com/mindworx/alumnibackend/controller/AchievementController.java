package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AchievementController {
    
    @GetMapping("/account/achievements")
    public String updateUserProfile(Model model) {
        model.addAttribute("title", "Achievements");
        return "pages/alumni/AchievementBar";
    }
    
    
}
