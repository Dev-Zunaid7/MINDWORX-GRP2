package com.mindworx.alumnibackend.controller;


import java.util.Collection;
import java.util.Optional;

import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/user")
public class HomeController {
    
    //get all the services for home/ 
    //get all services for testing
    @Autowired
    private UserService userServices;
    
    //testing method
    @GetMapping(" ")
    public Collection<Mindworxuser> getAllMindworxUsers(){
        return userServices.getAllMindworxUsers();
    }

    //testing getUser by id
    @GetMapping(value = "/{id}")
    public Optional<Mindworxuser> getMindworxUserById(@PathVariable int id){
        //check if the id exist first
        return userServices.getMindworxUserById(id);
    }

    //update user details
    @PutMapping(value = "/{id}")
    public void updateMindworxUser(@PathVariable int id, @RequestBody Mindworxuser mindworxuser){
       
        userServices.updateMindworxUser(id,mindworxuser);
    }
    //testing removeUser by id
    @DeleteMapping(value = "/{id}")
    public void removeMindworxUserById(@PathVariable int id){
        userServices.removeMindworxUserById(id);
                        
    }

    //create new user
    @PostMapping
     public void innsertMindworxuserToDb(@RequestBody Mindworxuser mindworxUser) {
         this.userServices.innsertMindworxuserToDb(mindworxUser);;
     }

    @GetMapping("/index")
    public String home(){
        return "pages/index";
    }

    @GetMapping("/alumni")
    public String user(){
        return ("<h1>Welcome to home feed page</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome to Administrator page</h1>");
    }

    @GetMapping("/coach")
    public String coach(){
        return ("<h1>Welcome to Coach page</h1>");
    }

    @GetMapping("/sign-up")
    public String register(){
        return "pages/register";
    }

    @GetMapping("/sign-in")
    public String login(){
        return "pages/sign";
    }


    @GetMapping("/forgot-password")
    public String passwordrest(){
        return "pages/resetpassword";
    }

    
 
}
