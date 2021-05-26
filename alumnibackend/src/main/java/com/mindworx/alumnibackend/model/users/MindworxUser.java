/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */

package com.mindworx.alumnibackend.model.users;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class Mindworxuser {

    
//These are attributes/data of a typical user.
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int sSID;

    @Column(
        name = "Name",
        nullable = false
    )
    private String  firstName;

    @Column(
        name = "Surname",
        nullable = false
    )
    private String  lastName;

    @Column(
        name = "Username",
        unique = true, 
        nullable = false
    )
    private String userName;

    @Column(
        name = "Initials",
        nullable = false
    )
    private String initials;

   @Column(
        name = "DOB",
        columnDefinition = "DATE",
        nullable = false
   )
    private Date dateofBirth;
    
    @Column(
        name = "Gender",
        nullable = true
    )
    private String gender;

    @Column(
        name = "Email",
        nullable = false,
        unique = true, 
        length = 255
    )
    private String  email;

    @Column(
        name = "Password",
        nullable = false, 
        length = 255
    )
    private String  password;

    @Column(
        name = "User_Type",
        nullable = false
    )

    @Enumerated(EnumType.STRING)
    private MindworxuserType typeofuser;

    @Column(name = "Blocked")
    private boolean active = false;

    @Column(name = "Enabled")
    private boolean Enabled = true;


//constructors to initialize the variables.
    
    public Mindworxuser(String firstName, String lastName, String userName,String initials, Date dateofBirth,
                      String gender,String email, String password,MindworxuserType typeofuser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.initials = initials;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.typeofuser = typeofuser;
    }

    
    public Mindworxuser() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
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

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public  MindworxuserType getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser( MindworxuserType typeofuser) {
        this.typeofuser = typeofuser;
    }
    

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getInitials() {
        return initials;
    }


    public void setInitials(String initials) {
        this.initials = initials;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return Enabled;
    }


    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }


}
