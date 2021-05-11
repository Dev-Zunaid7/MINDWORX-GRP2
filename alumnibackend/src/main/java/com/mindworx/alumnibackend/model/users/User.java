/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */

package com.mindworx.alumnibackend.model.users;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mindworxUser")
public class User {

//These are attributes/data of a typical user.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sSID;

   // @Column(nullable = false)
    private String  firstName;

   // @Column(nullable = false)
    private String  lastName;

    private String userName;

    private String initials;

   // @Column(nullable = false)
    private LocalDate dateofBirth;

    private char gender;

 //   @Column(nullable = false, unique = true, length = 255)
    private String  email;

 //   @Column(nullable = false, length = 30)
    private String  password;

 //   @Column(nullable = false, length = 50)
    private String typeofuser;

    private boolean active;


//constructors to initialize the variables.
    
    public User(int sSID, String firstName, String lastName, String userName, String initials, LocalDate dateofBirth,
                char gender, String email, String password, String typeofuser, boolean active) {
        this.sSID = sSID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.initials = initials;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.typeofuser = typeofuser;
        this.active = active;
    }

    
    public User() {
    }

    //accessor methods and store each into databae/retrieve each from database


    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIntials() {
        return initials;
    }

    public void setIntials(String intials) {
        this.initials = intials;
    }


    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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

    public int getsSID() {
        return sSID;
    }

    public void setsSID(int sSID) {
        this.sSID = sSID;
    }

    public String getPsw() {
        return password;
    }

    public void setPsw(String psw) {
        this.password = psw;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(String typeofuser) {
        this.typeofuser = typeofuser;
    }
    

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
