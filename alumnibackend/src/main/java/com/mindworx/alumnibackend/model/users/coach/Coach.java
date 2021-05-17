package com.mindworx.alumnibackend.model.users.coach;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.MindworxuserType;

//@Entity(name = "Coach")
public class Coach extends Mindworxuser {


    //Known fields of a coach user
    //  @Column(
    //      name = "Coach Qualif.",
    //      nullable = false
    //  )
    private String    coachQual;

    //  @Column(
    //      name = "Coach Profes. ",
    //      nullable = false
    //  )
    private String    coachProf;

    //  @Column(
    //      name = "Coach Organi.",
    //      nullable = true
    //  )
    private String    coachOrg;


    //Constructor to initialize the fields
    public Coach(@JsonProperty("sSID") int sSID,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("userName") String userName,@JsonProperty("initials") String initials,@JsonProperty("dateofBirth") LocalDate dateofBirth,
            @JsonProperty("gender") boolean gender,@JsonProperty("email") String email,@JsonProperty("password") String password,@JsonProperty("active") boolean active,
            @JsonProperty("coachQual") String coachQual,@JsonProperty("coachProf") String coachProf,@JsonProperty("coachOrg") String coachOrg) {
        super(sSID, firstName, lastName, userName, initials, dateofBirth, gender, email, password, MindworxuserType.COACH, active);

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
