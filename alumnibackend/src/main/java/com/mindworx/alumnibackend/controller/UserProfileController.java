package com.mindworx.alumnibackend.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.mindworx.alumnibackend.model.MindworxUserDetails;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;
import com.mindworx.alumnibackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


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

    //must update the profile picture. - this only updates the profile picture only.
    @PostMapping("/account/profile/updateprofile")
    public RedirectView updateprofile( Mindworxuser user,@AuthenticationPrincipal MindworxUserDetails loggedInUser, @RequestParam("profileImag") MultipartFile multipartFile) throws IOException {
        
        String flName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Mindworxuser mindworxuser = userService.getUserbyEmail(loggedInUser.getUsername());
       // mindworxuser.setProfileImage(flName);
        userService.updateMindworxUser(mindworxuser.getsSID(),user, flName);
        
        String postedfilefolder= "./userprofileImg/" + mindworxuser.getsSID(); //was changed from "./uploadedcontent/" + fileName" means has folder 1231-1313.jpg/1231-1313.jpg

        Path   uploadPath  = Paths.get(postedfilefolder) ;
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }


        try {
        
            InputStream inputStream = multipartFile.getInputStream();
            Path    filePath=   uploadPath.resolve(flName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file dude: " + flName,e);
        }
        return new RedirectView("/account/profile");
    }
}
