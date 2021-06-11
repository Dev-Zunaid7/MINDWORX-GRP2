package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    // only by user
    @GetMapping("/account/home")
    public String feed(Model model) {
        return "pages/alumni/feeds";
    }

}
