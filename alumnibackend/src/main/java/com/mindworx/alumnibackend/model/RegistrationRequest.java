package com.mindworx.alumnibackend.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RegistrationRequest {
    
    private final String  firstName;
    private final String  lastName;
    private final String  userName;
    private final String  email;
    private final Date    dateofBirth;
    private final boolean gender;
    private final String  password;
    private final String initials;


 
    public RegistrationRequest(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,
    @JsonProperty("dateofBirth") Date dateofBirth, @JsonProperty("gender")	boolean gender,@JsonProperty("email") String email,@JsonProperty("password") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.password = password;
        this.initials = initials;
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



    public Date getDateofbirDate() {
        return dateofBirth;
    }



    public boolean isGender() {
        return gender;
    }



    public String getPassword() {
        return password;
    }

    public String getInitials() {
        return initials;
    }


    @Override
    public String toString() {
        return "RegistrationRequest [dateofbirDate=" + dateofBirth + ", email=" + email + ", firstName="
                + firstName + ", gender=" + gender + ", lastName=" + lastName + ", password=" + password + ", userName="
                + userName  + ", intials=" + initials +"]";
    }
    
    
}
