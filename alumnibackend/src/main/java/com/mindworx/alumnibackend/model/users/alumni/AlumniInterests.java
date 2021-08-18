package com.mindworx.alumnibackend.model.users.alumni;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "alumni_interest")
public class AlumniInterests {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sectorID")
    private Long sectorID;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Alumni alumni;

    @Column(name = "sector_name")
    private String interestSector;

    public AlumniInterests() {
    }

    public AlumniInterests(Alumni alumni, String interestSector) {
        this.alumni = alumni;
        this.interestSector = interestSector;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public String getInterestSector() {
        return interestSector;
    }

    public void setInterestSector(String interestSector) {
        this.interestSector = interestSector;
    }

    

    


}
