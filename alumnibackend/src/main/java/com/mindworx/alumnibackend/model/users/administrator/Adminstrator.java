package com.mindworx.alumnibackend.model.users.administrator;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mindworx.alumnibackend.model.users.MindworxUser;

@Entity(name = "Adminstrator")
public class Adminstrator extends MindworxUser {

    //Known fields for an Administrator

    private Long    adminCode;
    

    private String  adminDept;


    //Constructors to initialize the fields
    public Adminstrator(int sSID, String firstName, String lastName, String userName, String initials,
            LocalDate dateofBirth, boolean gender, String email, String password, String typeofuser, boolean active,
            Long adminCode, String adminDept) {
        super(sSID, firstName, lastName, userName, initials, dateofBirth, gender, email, password, typeofuser, active);
   
        this.adminCode = adminCode;
        this.adminDept = adminDept;
    }

    public Adminstrator() {
    }


    //Accessor methods

    public Long getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Long adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminDept() {
        return adminDept;
    }

    public void setAdminDept(String adminDept) {
        this.adminDept = adminDept;
    }

    //string for admin details
    @Override
    public String toString() {
        return "Adminstrator [adminCode=" + adminCode + ", adminDept=" + adminDept + "]";
    }

    
}
