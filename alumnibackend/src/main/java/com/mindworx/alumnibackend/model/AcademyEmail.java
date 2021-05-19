package com.mindworx.alumnibackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AcademyEmail {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column(name = "AcademyEmail")
    private String academyEmail;
    @Column(name = "Blocked")
    private boolean isBlocked;

    
    public AcademyEmail( String academyEmail) {
        this.academyEmail = academyEmail;
    }


    public AcademyEmail() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAcademyEmail() {
        return academyEmail;
    }


    public void setAcademyEmail(String academyEmail) {
        this.academyEmail = academyEmail;
    }


    public boolean getIsBlocked() {
        return isBlocked;
    }


    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }



 

    
}
