/**
 * This model class serves to solve the business logic to register a user
 * to the system.
 * 
 */
package com.mindworx.alumnibackend.model.system;

import java.time.LocalDate;
import java.util.List;

import com.mindworx.alumnibackend.model.users.User;

public class Register {
    
    //attributes to register user
    private User userProfile;
    private String   usertype;

    public Register(User userProfile) {
        this.userProfile = userProfile;
    }
    

    //Methods to register user

    /**
     * Function to a type of user.
     * User selects from three catelogs (ALUMNI - COACH - ADMINISTRA) 
     * @param int for taking the choice Catelog option.
     * @return type of user(ALUMNI - COACH - ADMINSTRATOR)
     */
    public String registerUserType(int choice){

        return null;

    }
    
    /**
     * This method serves to register a user.
     */
    public void registerUser(List userlist){
        
        // userProfile.setsSID((Long)userlist.get(1));
        // userProfile.setFirstName(userlist.get(2).toString());
        // userProfile.setLastName(userlist.get(3).toString());
        // userProfile.setDateofBirth((LocalDate)userlist.get(4));
        // userProfile.setEmail(userlist.get(5).toString());
        // userProfile.setPsw(userlist.get(6).toString());
        
    }

}
