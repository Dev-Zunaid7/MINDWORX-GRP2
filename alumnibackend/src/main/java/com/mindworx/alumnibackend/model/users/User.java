/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */

package com.mindworx.alumnibackend.model.users;

import java.time.LocalDate;


public abstract class User<T> {

//These are attributes/data of a typical user.
    private Long    sSID;
    private String  firstName;
    private String  lastName;
    private LocalDate dateofBirth;
    private String  email;
    private String  psw;


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

    //accessor methods and store each into databae/retrieve each from database
    
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
    

}
