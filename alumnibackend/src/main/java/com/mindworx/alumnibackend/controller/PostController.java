package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    // only by user


    @GetMapping("/account/home")
    public String feed(Model model) {

        return  "pages/alumni/feeds";
    }

}
