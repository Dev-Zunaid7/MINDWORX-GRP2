package com.mindworx.alumnibackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacilitatorController {
    
    //only by coach
    @GetMapping("/coach")
    public String coach(){
        return "pages/coachboard";
    }
}
