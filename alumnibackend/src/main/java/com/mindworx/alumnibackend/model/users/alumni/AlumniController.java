/**
 * Servlet implementation, this class serves as one of the API layer handler of Alumni Request&Response of the Alumni Appilcation.
 */
package com.mindworx.alumnibackend.model.users.alumni;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.mindworx.alumnibackend.model.users.UserServices;

@RestController
@RequestMapping(path = "api/v0/alumni")
public class AlumniController {
    
    //access to alumni serivces from client/alumni side. 
    private final UserServices alumniServices;

    @Autowired
    public AlumniController(UserServices alumniServices) {
        this.alumniServices = alumniServices;
    }


    //returns all the Alumni in the list.
    @GetMapping
    protected List<Alumni> getAlumniDetail(){   
        //Redirect this to our View level architecture.
        return  null;
    }

    /**
     * Get single Alumni details from database.
     * @parm pass the index or id of the Alumni as argument.
     */
}
