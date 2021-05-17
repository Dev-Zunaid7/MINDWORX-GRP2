/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */

package com.mindworx.alumnibackend.model.users;

import java.time.LocalDate;

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
public class Mindworxuser{

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
        nullable = false
   )
    private LocalDate dateofBirth;
    
    @Column(
        name = "Gender",
        nullable = true
    )
    private boolean gender;

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
    private boolean active;


//constructors to initialize the variables.
    
    public Mindworxuser(@JsonProperty("sSID") int sSID,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,@JsonProperty("dateofBirth") LocalDate dateofBirth,
                       @JsonProperty("gender") boolean gender,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("typeofuser") MindworxuserType typeofuser,@JsonProperty("active") boolean active) {
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

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
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

}
