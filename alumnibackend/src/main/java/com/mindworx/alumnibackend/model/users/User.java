package com.mindworx.alumnibackend.model.users;

import java.time.LocalDate;

import com.mindworx.alumnibackend.controller.LoginController;
import com.mindworx.alumnibackend.controller.RegistrationController;

public abstract class User {

    //These are attributes of a typical user requested.
    private Long    sSID;
    private String  firstName;
    private String  lastName;
    private LocalDate dateofBirth;
    private String  email;
    private String  psw;
    private RegistrationController registerUser;
    private LoginController loginUser;

//constructors to initialize the variables.

    public User() {
    }

    // public User(Long sSID,
    //             String firstName, 
    //             String lastName, 
    //             LocalDate dateofBirth, 
    //             String email,  
    //             String psw,
    //             RegistrationController registerUser, 
    //             LoginController loginUser) {
    //     this.sSID = sSID;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.dateofBirth = dateofBirth;
    //     this.email = email;
    //     this.psw = psw;
    //   //  this.registerUser = registerUser;
    //    // this.loginUser = loginUser;
    // }


    
    public User(Long sSID, String firstName, String lastName, LocalDate dateofBirth, String email, String psw) {
        this.sSID = sSID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.email = email;
        this.psw = psw;
    }

    //accessor methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getsSID() {
        return sSID;
    }

    public void setsSID(Long sSID) {
        this.sSID = sSID;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

//user functions. 

//register or sign-up user.
//     public RegistrationController getRegisterUser() {
//         return registerUser;
//     }

//     public void setRegisterUser(RegistrationController registerUser) {
//         this.registerUser = registerUser;
//     }

// //login or sign-in user.
//     public LoginController getLoginUser() {
//         return loginUser;
//     }

//     public void setLoginUser(LoginController loginUser) {
//         this.loginUser = loginUser;
//     }

//toString for displaying.
    @Override
    public String toString() {
        return "[dateofBirth= " + dateofBirth + "\n" + 
               "email= " + email + "\n" + 
               "firstName= " + firstName + "\n" + 
               "lastName= "+ lastName + "\n" +
               "psw=" + psw + "\n" +
               "sSID=" + sSID + "]";
    }


}
