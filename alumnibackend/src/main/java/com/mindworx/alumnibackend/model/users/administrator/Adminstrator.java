package com.mindworx.alumnibackend.model.users.administrator;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.MindworxuserType;

@Entity
@Table(name = "app_admin")
public class Adminstrator extends Mindworxuser {

    //Known fields for an Administrator
    
    @Column(
        name = "Admin_Dept"
    )
    private String  adminDept;


    //Constructors to initialize the fields
    public Adminstrator(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,
                       @JsonProperty("dateofBirth") Date dateofBirth, @JsonProperty("gender")	String gender,@JsonProperty("email") String email,@JsonProperty("password") String password,
                        @JsonProperty("adminDept")  String adminDept) {
        super(firstName, lastName, userName, initials, dateofBirth, gender, email, password, MindworxuserType.ADMIN);
   
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
