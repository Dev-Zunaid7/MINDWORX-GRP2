package com.mindworx.alumnibackend.model.token;

import org.springframework.beans.factory.annotation.Autowired;
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


    // public ConfirmationToken getToken(String token) {
    //     return null;
    // }




    
}
