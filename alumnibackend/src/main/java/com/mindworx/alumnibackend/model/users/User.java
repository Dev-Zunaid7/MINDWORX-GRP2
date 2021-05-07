package com.mindworx.alumnibackend.model.users;

import java.time.LocalDate;
import java.util.List;


public abstract class User<T> {

//These are attributes of a typical user requested.
    private Long    sSID;
    private String  firstName;
    private String  lastName;
    private LocalDate dateofBirth;
    private String  email;
    private String  psw;

    // @JsonManagedReference
    // protected List<T> listUsers;

//constructors to initialize the variables.
    

     public User() {
     }

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

    //get all user details.
    public abstract List<T> getUserDetails();

    //get single user details.




//user functions. 

//register or sign-up user.

// //login or sign-in user.
    

}
