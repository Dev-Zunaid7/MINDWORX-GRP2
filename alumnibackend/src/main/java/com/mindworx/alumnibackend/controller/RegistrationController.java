package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.RegistrationRequest;
import com.mindworx.alumnibackend.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;




@Controller
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;
    
    //Contructor
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // //
    @ModelAttribute("alumni")
    public RegistrationRequest registrationRequest( Model model){
        return new RegistrationRequest();
      }

    @PostMapping()
    public String register(@ModelAttribute("alumni") RegistrationRequest registrationRequest, BindingResult result) {
        //return response to client side.
        
        System.out.println(registrationRequest.getEmail() +"\n" + 
                            registrationRequest.getGender() +"\n" +
                            registrationRequest.getFirstName() +"\n" +
                            registrationRequest.getLastName() +"\n" +
                            registrationRequest.getInitials() +"\n" +
                            registrationRequest.getPassword() +"\n" +
                            registrationRequest.getAlumInterests() +"\n" +
                            registrationRequest.getGender() +"\n" +
                            registrationRequest.getAlumAddress() + "\n" +
                            registrationRequest.getAlumWorkplace());

                            
        String response = registrationService.register(registrationRequest);
        System.out.println("Response messsage: " + response);

        return "redirect:/registration?success";

    }

    @GetMapping()
    public String showRegistrationForm() {
        return "pages/register";
    }
    
    // @GetMapping(path = "confirm")
    // public String confirm(@RequestParam("token") String token){
    //     return registrationService.confirmToken(token);
    // } 
}
