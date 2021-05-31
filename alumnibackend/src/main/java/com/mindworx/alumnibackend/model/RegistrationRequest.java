package com.mindworx.alumnibackend.model;

import java.sql.Date;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RegistrationRequest {
    
    private  String  firstName;
    private  String  lastName;
    private  String  userName;
    private  String  email;
    private  Date    dateofBirth;
    private  String gender;
    private  String  password;
    private  String initials;
    //alumni registration only
    private String	alumInterests;
    private boolean	alumEmployed;
    private String	alumWorkplace;
    private String	alumAddress;
    


    //REGISTER AN ALUMNI CONSTRUCTOR.
    public RegistrationRequest(String firstName, String lastName, String userName,String initials, Date dateofBirth,String gender,
                               String email, String password,String alumInterests,boolean alumEmployed,String alumWorkplace,String alumAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.initials = initials;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.alumInterests = alumInterests;
        this.alumEmployed = alumEmployed;
        this.alumWorkplace = alumWorkplace;
        this.alumAddress = alumAddress;
    }


    public RegistrationRequest() {
    }


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


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDateofBirth() {
        return dateofBirth;
    }


    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getInitials() {
        return initials;
    }


    public void setInitials(String initials) {
        this.initials = initials;
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
