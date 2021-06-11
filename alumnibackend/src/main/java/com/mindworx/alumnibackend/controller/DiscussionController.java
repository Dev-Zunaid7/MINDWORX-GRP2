package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscussionController {

    // only by user
    @GetMapping("/account/discuss")
    public String feed(Model model) {
        return "pages/alumni/discuss";
    }

}
