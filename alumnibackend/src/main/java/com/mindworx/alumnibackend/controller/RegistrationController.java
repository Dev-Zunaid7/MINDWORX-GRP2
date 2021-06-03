package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.RegistrationRequest;
import com.mindworx.alumnibackend.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




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
    @GetMapping()
    public String registrationRequest(Model model){
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "pages/register";
      }

    @PostMapping()
    public String register(Model model, @ModelAttribute RegistrationRequest registrationRequest) {
        //return response to client side.
                            
       
         String response = registrationService.registerAlumni(registrationRequest);
     
       System.out.println("Response messsage: " + response);
        return "redirect:/registration?success";

    }

    @PostMapping("/admin/new")
    public String registerAdmin(Model model, @ModelAttribute RegistrationRequest registrationRequest) {
        //return response to client side.
                            
       
        String response = registrationService.registerAdministrator(registrationRequest);
     
        System.out.println("Response messsage: " + response);
        return "redirect:/registration?success";

    }

    @PostMapping("/coach/new")
    public String registerCoach(Model model, @ModelAttribute RegistrationRequest registrationRequest) {
        //return response to client side.
                            
        String response = registrationService.registerCoach(registrationRequest);
     
        System.out.println("Response messsage: " + response);
        return "redirect:/registration?success";

    }

    // @GetMapping()
    // public String showRegistrationForm() {
    //     return "pages/register";
    // }
    
    // @GetMapping(path = "confirm")
    // public String confirm(@RequestParam("token") String token){
    //     return registrationService.confirmToken(token);
    // } 
}
