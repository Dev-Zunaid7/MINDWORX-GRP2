package com.mindworx.alumnibackend.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RegistrationRequest {
    
    private final String  firstName;
    private final String  lastName;
    private final String  userName;
    private final String  email;
    private final Date    dateofBirth;
    private final String gender;
    private final String  password;
    private final String initials;
    //alumni registration only
    private String	alumInterests;
    private boolean	alumEmployed;
    private String	alumWorkplace;
    private String	alumAddress;
    


    //REGISTER AN ALUMNI CONSTRUCTOR.
    public RegistrationRequest(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,
                              @JsonProperty("dateofBirth") Date dateofBirth, @JsonProperty("gender") String gender,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("alumInterests") String alumInterests,
                              @JsonProperty("alumEmployed") boolean alumEmployed,@JsonProperty("alumWorkplace") String alumWorkplace,@JsonProperty("alumAddress") String alumAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.password = password;
        this.initials = initials;
        this.alumInterests = alumInterests;
        this.alumEmployed = alumEmployed;
        this.alumWorkplace = alumWorkplace;
        this.alumAddress = alumAddress;
    }



    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getUserName() {
        return userName;
    }



    public String getEmail() {
        return email;
    }



    public Date getDateofBirth() {
        return dateofBirth;
    }



    public String getGender() {
        return gender;
    }



    public String getPassword() {
        return password;
    }



    public String getInitials() {
        return initials;
    }



    public String getAlumInterests() {
        return alumInterests;
    }



    public void setAlumInterests(String alumInterests) {
        this.alumInterests = alumInterests;
    }



    public boolean isAlumEmployed() {
        return alumEmployed;
    }



    public void setAlumEmployed(boolean alumEmployed) {
        this.alumEmployed = alumEmployed;
    }



    public String getAlumWorkplace() {
        return alumWorkplace;
    }



    public void setAlumWorkplace(String alumWorkplace) {
        this.alumWorkplace = alumWorkplace;
    }



    public String getAlumAddress() {
        return alumAddress;
    }



    public void setAlumAddress(String alumAddress) {
        this.alumAddress = alumAddress;
    }

    
//ACCESSOR METHODS



}
