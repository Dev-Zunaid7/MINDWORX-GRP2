package com.mindworx.alumnibackend.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private Date dateofBirth;
    private String gender;
    private String password;
    private String initials;
    // ALUMNI registration
    private boolean alumEmployed;
    private String alumWorkplace;
    private String alumAddress;
    // ADMINISTRATOR/COORDINATOR registration
    private String adminDept;
    // COACH/FACILITATOR registration
    private String coachQual;
    private String coachProf;
    private String coachOrg;

    // REGISTER AN ALUMNI CONSTRUCTOR.
    public RegistrationRequest(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,@JsonProperty("DOB") Date dateofBirth,
	@JsonProperty("gender") String gender,@JsonProperty("emailaddress") String email,@JsonProperty("psw") String password,@JsonProperty("alumEmployed") boolean alumEmployed,@JsonProperty("alumWorkplace") String alumWorkplace,@JsonProperty("alumAddress")	String alumAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.initials = initials;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.alumEmployed = alumEmployed;
        this.alumWorkplace = alumWorkplace;
        this.alumAddress = alumAddress;
    }
    // for
    public RegistrationRequest() {
    }

    // REGISTER AN ADMINISTRATOR CONSTRUCTOR.
    public RegistrationRequest(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("emailaddress") String email,@JsonProperty("DOB") Date dateofBirth,
    @JsonProperty("gender") String gender,@JsonProperty("psw") String password,@JsonProperty("initials") String initials,@JsonProperty("adminDept") String adminDept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.password = password;
        this.initials = initials;
        this.adminDept = adminDept;
    }

    // REGISTER A COACH CONSTRUCTOR.
    public RegistrationRequest(String firstName, String lastName, String userName, String email, Date dateofBirth,
            String gender, String password, String initials, String coachQual, String coachProf, String coachOrg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.password = password;
        this.initials = initials;
        this.coachQual = coachQual;
        this.coachProf = coachProf;
        this.coachOrg = coachOrg;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAdminDept() {
        return adminDept;
    }

    public void setAdminDept(String adminDept) {
        this.adminDept = adminDept;
    }

    public String getCoachQual() {
        return coachQual;
    }

    public void setCoachQual(String coachQual) {
        this.coachQual = coachQual;
    }

    public String getCoachProf() {
        return coachProf;
    }

    public void setCoachProf(String coachProf) {
        this.coachProf = coachProf;
    }

    public String getCoachOrg() {
        return coachOrg;
    }

    public void setCoachOrg(String coachOrg) {
        this.coachOrg = coachOrg;
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

    // ACCESSOR METHODS

}
