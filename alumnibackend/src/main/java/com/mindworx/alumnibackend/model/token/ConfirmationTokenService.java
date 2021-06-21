package com.mindworx.alumnibackend.model.token;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
    
    private final ConfirmationTokenDao confirmationTokenDao;


    @Autowired
    public ConfirmationTokenService(ConfirmationTokenDao confirmationTokenDao) {
        this.confirmationTokenDao = confirmationTokenDao;
    }


    public void saveConfirmationToken(ConfirmationToken confirmationToken){

        confirmationTokenDao.save(confirmationToken);
    }


    public ConfirmationToken getToken(String token) { //.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
         ConfirmationToken confirmationToken = confirmationTokenDao.findByToken(token).orElseThrow(() -> new UsernameNotFoundException("token issue over here."));
        return confirmationToken;
    }


    public void setConfirmedAt(String token) {
       ConfirmationToken confirmationToken = getToken(token);
       confirmationToken.setConfirmedAt(LocalDateTime.now());
    }




    
}
