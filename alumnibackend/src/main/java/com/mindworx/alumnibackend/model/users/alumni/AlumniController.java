package com.mindworx.alumnibackend.model.users.alumni;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mindworx.alumnibackend.model.users.User;

@RestController
@RequestMapping(path = "api/v0/alumni")
public class AlumniController {
    
    //access to alumni serivces from client/alumni side. 
    @JsonBackReference
    private final User<Alumni> alumniServices;

    @Autowired
    public AlumniController(User<Alumni> alumniServices) {
        this.alumniServices = alumniServices;
    }

    //returns all the Alumni in the list.
    @GetMapping
    public List<Alumni> getAlumniDetail(){   
        return  alumniServices.getUserDetails();
    }

    /**
     * Get single Alumni details from database.
     * @parm pass the index or id of the Alumni as argument.
     */
}
