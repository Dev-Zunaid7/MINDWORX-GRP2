package com.mindworx.alumnibackend.controller;

import com.mindworx.alumnibackend.model.MindworxUserDetails;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;
import com.mindworx.alumnibackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/account/profile")
    public String updateUserProfile(Model model, @AuthenticationPrincipal MindworxUserDetails loggedInUser) {
        model.addAttribute("title", "Account Profile");
        
        Alumni mindworxuser = userService.getUserbyEmail(loggedInUser.getUsername());
        model.addAttribute("Profile",mindworxuser);

        return "pages/alumni/profile";
    }



    @GetMapping("/account/settings")
    public String getChangeSettings(Model model) {
        model.addAttribute("title", "Account Settings");
        return "pages/settings";
    }
}
