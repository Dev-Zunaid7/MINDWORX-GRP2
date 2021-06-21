package com.mindworx.alumnibackend.controller;


import com.mindworx.alumnibackend.model.RegistrationRequest;
import com.mindworx.alumnibackend.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




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
                            
        try {
            registrationService.registerAlumni(registrationRequest);
        } catch (IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
            return "pages/register";
        }   

    
     
//       System.out.println("Response messsage: " + response);
        return "redirect:/registration?success";

    }

    @PostMapping("/admin/new")
    public String registerAdmin(Model model, @RequestBody RegistrationRequest registrationRequest) {
        //return response to client side.
          try {
            registrationService.registerAdministrator(registrationRequest);
          } catch (IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
          }                  

        //return message in admin page for new admin user to confirm registration on their email.
        return "redirect:/registration?success";

    }

    @PostMapping("/coach/new")
    public String registerCoach(Model model, @ModelAttribute RegistrationRequest registrationRequest) {
     
        try {
            registrationService.registerCoach(registrationRequest);
          } catch (IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
          }                  

        //return message in admin page for new coach user to confirm registration on their email.
        return "redirect:/registration?success";

    }
    
    //confirmation link, redirect user to login page after clicked.
    //notify adminstrator of the new confirmation.
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token, Model model){
        
        try {
            registrationService.confirmToken(token);
          } catch (IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
          }      
        return "redirect:/login" ;
    } 
}
