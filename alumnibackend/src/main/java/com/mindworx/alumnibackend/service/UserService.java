package com.mindworx.alumnibackend.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.mindworx.alumnibackend.dao.IUserdao;
import com.mindworx.alumnibackend.model.token.ConfirmationToken;
import com.mindworx.alumnibackend.model.token.ConfirmationTokenService;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    
    //accessing the user dao

    private final IUserdao mindworxuserDao;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public UserService(IUserdao mindworxuserDao, PasswordEncoder passwordEncoder,ConfirmationTokenService confirmationTokenService) {
        this.mindworxuserDao = mindworxuserDao;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService= confirmationTokenService;
    }

        //     //get all users in the database
    public Collection<Mindworxuser> getAllMindworxUsers(){
        return mindworxuserDao.findAll();
    }

        //     //get a user by id in database
    public Optional<Mindworxuser> getMindworxUserById(int id){
        //check if the id exist first
        return mindworxuserDao.findById(id);
    }

    //      //remove a user from database
    public void removeMindworxUserById(int id){
         mindworxuserDao.deleteById(id);
    }

    //      //update user details in database
    public void updateMindworxUser(int id, Mindworxuser mindworxuser){
       
     //this.mindworxuserDao.saveAndFlush(id,mindworxuser);
    }

    public void innsertMindworxuserToDb(Mindworxuser mindworxUser) {
        this.mindworxuserDao.save(mindworxUser);
    }

    //method for log-in security.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      //verify user by email
        return mindworxuserDao.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user email %s not found"));
    }

    //function to sendback suer
    public String signUpUser(Mindworxuser mindworxuser){
        //verify user by email if already exists
      boolean userEmailExists=  mindworxuserDao.findByEmail(mindworxuser.getEmail())
                        .isPresent();
        if(userEmailExists){
            throw new IllegalStateException("email already taken.");
        }

        String encodedPassword = passwordEncoder.encode(mindworxuser.getPassword());

        mindworxuser.setPsw(encodedPassword);
        
        mindworxuserDao.save(mindworxuser);
        
        String token = UUID.randomUUID().toString();
        //Send confirmation of user
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), mindworxuser);
        
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //send a user an email to confirm registration.

        return "confirmed";
    }

    public void enableMindworxUser(String email) {
        //iterate or filter to find the email passed
        //update the enable of the passed user.
    }
}
