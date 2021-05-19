package com.mindworx.alumnibackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/home")
public class HomeController {
    
     @GetMapping("/index")
    public String home(){
        return "pages/index";
    }

    @GetMapping("/sign-up")
    public String register(){
        return "pages/register";
    }

    @GetMapping("")
    public String login(){
        return "pages/sign";
    }


    @GetMapping("/forgot-password")
    public String passwordrest(){
        return "pages/resetpassword";
    }


}




    
    //get all the services for home/ 
    //get all services for testing
    // @Autowired
    // private UserService userServices;
    
    // //testing method
    // @GetMapping("/user")
    // public Collection<Mindworxuser> getAllMindworxUsers(){
    //     return userServices.getAllMindworxUsers();
    // }

    // //testing getUser by id
    // @GetMapping(value = "/user/{id}")
    // public Optional<Mindworxuser> getMindworxUserById(@PathVariable int id){
    //     //check if the id exist first
    //     return userServices.getMindworxUserById(id);
    // }

    // //update user details
    // @PutMapping(value = "/user/{id}")
    // public void updateMindworxUser(@PathVariable int id, @RequestBody Mindworxuser mindworxuser){
       
    //     userServices.updateMindworxUser(id,mindworxuser);
    // }
    // //testing removeUser by id
    // @DeleteMapping(value = "/user/{id}")
    // public void removeMindworxUserById(@PathVariable int id){
    //     userServices.removeMindworxUserById(id);
                        
    // }

    // //create new user
    // @PostMapping("/user")
    //  public void innsertMindworxuserToDb(@RequestBody Mindworxuser mindworxUser) {
    //      this.userServices.innsertMindworxuserToDb(mindworxUser);
    //  }
