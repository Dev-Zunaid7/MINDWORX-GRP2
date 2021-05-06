package com.mindworx.alumnibackend.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.mindworx.alumnibackend.model.users.alumni.Alumni;

@RestController
@RequestMapping(path = "api/v0/alumni")
public class AlumniController {
    
    //access to alumni serivces from client/alumni side. 
    private final Alumni  alumniService;

    public AlumniController(Alumni alumniService) {
        this.alumniService = alumniService;
    }

    
    @GetMapping
    public List<Alumni> getAlumniDetail(){
        return alumniService.getAlumniDetails();
    }
}
