package com.mindworx.alumnibackend.service;

import java.util.List;

import com.mindworx.alumnibackend.dao.IAcademyEmaildao;
import com.mindworx.alumnibackend.model.AcademyEmail;
import com.mindworx.alumnibackend.model.RegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AcademyEmailService {

    @Autowired
    private final IAcademyEmaildao academyEmaildao;

    public AcademyEmailService(IAcademyEmaildao academyEmaildao) {
        this.academyEmaildao = academyEmaildao;
    }

    public boolean IsWithAcademy(String email) {
        //iterate through database and check if this email is in our email record.
       //Optional<AcademyEmail> academyEmail = academyEmaildao.findByEmail(email);
       List<AcademyEmail> listEmails = academyEmaildao.findAll();
      

       for (AcademyEmail academyEmail : listEmails) {
            if(academyEmail.getAcademyEmail().equalsIgnoreCase(email)){
                return true;
        }
       }

       return false;
    }

    public boolean isAllowed(String email) {
        List<AcademyEmail> listEmails = academyEmaildao.findAll();
     

        for (AcademyEmail academyEmail : listEmails) {
             if(academyEmail.getAcademyEmail().equalsIgnoreCase(email)){
                 if(academyEmail.getIsBlocked() == true){
                     return false;
                 }
             }
         }  
         return true;


   
    }


    
}
