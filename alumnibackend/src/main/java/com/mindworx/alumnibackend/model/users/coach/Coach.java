package com.mindworx.alumnibackend.model.users.coach;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.MindworxuserType;


@Entity
@Table(name = "app_coach")
public class Coach extends Mindworxuser {


    //Known fields of a coach user
     @Column(
         name = "Coach_Qualif",
         nullable = false
     )
    private String    coachQual;

     @Column(
         name = "Coach_Profes",
         nullable = false
     )
    private String    coachProf;

     @Column(
         name = "Coach_Organi",
         nullable = true
     )
    private String    coachOrg;


    //Constructor to initialize the fields
    public Coach(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,@JsonProperty("dateofBirth") Date dateofBirth,
            @JsonProperty("gender") boolean gender,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("coachQual") String coachQual,@JsonProperty("coachProf") String coachProf,@JsonProperty("coachOrg") String coachOrg) {
        super(firstName, lastName, userName, initials, dateofBirth, gender, email, password, MindworxuserType.COACH);

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
