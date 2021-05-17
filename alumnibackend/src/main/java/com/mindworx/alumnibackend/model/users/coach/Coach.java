package com.mindworx.alumnibackend.model.users.coach;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;


import com.mindworx.alumnibackend.model.users.MindworxUser;
import com.mindworx.alumnibackend.model.users.Usertype;

@Entity(name = "Coach")
public class Coach extends MindworxUser {


    //Known fields of a coach user
     @Column(
         name = "Coach Qualif.",
         nullable = false
     )
    private String    coachQual;

     @Column(
         name = "Coach Profes. ",
         nullable = false
     )
    private String    coachProf;

     @Column(
         name = "Coach Organi.",
         nullable = true
     )
    private String    coachOrg;


    //Constructor to initialize the fields
    public Coach(int sSID, String firstName, String lastName, String userName, String initials, LocalDate dateofBirth,
            boolean gender, String email, String password, Usertype typeofuser, boolean active,
            String coachQual, String coachProf, String coachOrg) {
        super(sSID, firstName, lastName, userName, initials, dateofBirth, gender, email, password, typeofuser, active);

        this.coachQual = coachQual;
        this.coachProf = coachProf;
        this.coachOrg = coachOrg;
    }


    public Coach() {
    }    
    
    //Accessor methods

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


    //toString returns Coach details.
    @Override
    public String toString() {
        return "Coach [ coachOrg=" + coachOrg + ", coachProf="
                + coachProf + ", coachQual=" + coachQual + "]";
    }     
        

    
}
