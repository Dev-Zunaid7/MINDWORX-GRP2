package com.mindworx.alumnibackend.service;



import com.mindworx.alumnibackend.email.EmailSender;
import com.mindworx.alumnibackend.model.RegistrationRequest;

import com.mindworx.alumnibackend.model.token.ConfirmationTokenService;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;


    

    @Autowired
    public RegistrationService(UserService userService, EmailValidator emailValidator,
            ConfirmationTokenService confirmationTokenService, EmailSender emailSender) {
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSender = emailSender;
    }


    public String register(RegistrationRequest request) {

        String token = userService.signUpUser(new Alumni( request.getFirstName(),request.getLastName(),request.getUserName(), request.getInitials(), request.getDateofBirth(),
                                                  request.getGender(), request.getEmail(), request.getPassword(), request.getAlumInterests(), request.isAlumEmployed(), request.getAlumWorkplace(), request.getAlumAddress()));
    
        // String link = "";
        // emailSender.send(request.getEmail(), buildEmail(request.getFirstName(),link));
         return token;
    }


}









    //this is not logically working- checking of the token confirmation if it exist and enable the user
    // // public String confirmToken(String token){
    // //     ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);

    // //     if(confirmationToken.getConfirmedAt() != null){

    // //         throw new IllegalStateException("email already confirmed");
    // //     }
    // //     LocalDateTime expiredAt = confirmationToken.getexpiresAt();

    // //     if(expiredAt.isBefore(LocalDateTime.now())){
    // //         throw new IllegalStateException("token has expired");
    // //     }

    // //     confirmationTokenService.setConfirmedAt(token);
    // //     userService.enableMindworxUser( confirmationToken.getMindworxuser().getEmail());
    // //     return "confirmed";
    // // }
