package com.mindworx.alumnibackend.model.users.administrator;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mindworx.alumnibackend.model.users.Mindworxuser;

@Entity
@Table(name = "app_admin")
public class Adminstrator extends Mindworxuser {

    // Known fields for an Administrator

    @Column(name = "Admin_Dept")
    private String adminDept;

    // Constructors to initialize the fields
    public Adminstrator(String firstName, String lastName, String userName, String initials, Date dateofBirth,
    String gender, String email, String password,String adminDept) {

        super(firstName, lastName, userName, initials, dateofBirth, gender, email, password);
        this.adminDept = adminDept;
    }

    public Adminstrator() {
    }

    // Accessor methods

    public String getAdminDept() {
        return adminDept;
    }

    public void setAdminDept(String adminDept) {
        this.adminDept = adminDept;
    }

    // string for admin details
    @Override
    public String toString() {
        return "Adminstrator [ adminDept=" + adminDept + "]";
    }

}
