package com.mindworx.alumnibackend.model.users;

import java.util.List;

import com.mindworx.alumnibackend.model.users.alumni.Alumni;

import org.springframework.stereotype.Service;

@Service
public abstract class UserServices<T> {
  
    //get all user details.
    public abstract List<Alumni> getUserDetails();

    //get single user details.
  
  
  
  
  //user functions. 
  
  //register or sign-up user.
  
  // //login or sign-in user.
}
