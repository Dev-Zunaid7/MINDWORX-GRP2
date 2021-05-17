package com.mindworx.alumnibackend.model.users.administrator;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.MindworxuserType;

//@Entity(name = "Adminstrator")
public class Adminstrator extends Mindworxuser {

    //Known fields for an Administrator
    
    // @Column(
    //     name = "Admin Dept. "
    // )
    private String  adminDept;


    //Constructors to initialize the fields
    public Adminstrator(@JsonProperty("sSID")int sSID,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,
                       @JsonProperty("dateofBirth") LocalDate dateofBirth, @JsonProperty("gender")	boolean gender,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("active") boolean active,
                       @JsonProperty("adminDept")  String adminDept) {
        super(sSID, firstName, lastName, userName, initials, dateofBirth, gender, email, password, MindworxuserType.ADMIN, active);
   
        this.adminDept = adminDept;
    }

    public Adminstrator() {
    }


    //Accessor methods

    public String getAdminDept() {
        return adminDept;
    }

    public void setAdminDept(String adminDept) {
        this.adminDept = adminDept;
    }

    //string for admin details
    @Override
    public String toString() {
        return "Adminstrator [ adminDept=" + adminDept + "]";
    }

    
}
