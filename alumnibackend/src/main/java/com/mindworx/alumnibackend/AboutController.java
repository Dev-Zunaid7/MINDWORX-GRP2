package com.mindworx.alumnibackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class AboutController {
    
    @GetMapping("/")
    public String getAbout() {
        return "Hello from About page Spring boot backend.";
    }
    
}
