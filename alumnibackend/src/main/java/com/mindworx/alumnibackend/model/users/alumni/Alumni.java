/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */
package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mindworx.alumnibackend.model.users.MindworxUser;


@Entity(name = "Alumni")
public class Alumni extends MindworxUser {
	
	//Known fields for an Alumni
	// @Column(
    //     name = "Alum Code",
    //     nullable = false,
    //     unique = true, 
	// 	updatable = false
    // )
	private Long	alumCode;

	// @Column(
    //     name = "Alum Interest",
    //     nullable = true
    // )
	private String	alumInterests;

	// @Column(
    //     name = "Alum Employed",
    //     nullable = false
    // )
	private boolean	alumEmployed;

	// @Column(
    //     name = "Alum Workplace",
    //     nullable = true
    // )
	private String	alumWorkplace;

	// @Column(
    //     name = "Alum Address",
    //     nullable = true
    // )
	private String	alumAddress;

	
	//Contructor to initialize the fields
	public Alumni() {
	}


	public Alumni(int sSID, String firstName, String lastName, String userName, String initials, LocalDate dateofBirth,
			boolean gender, String email, String password, String typeofuser, boolean active, Long alumCode,
			String alumInterests, boolean alumEmployed, String alumWorkplace, String alumAddress) {
		super(sSID, firstName, lastName, userName, initials, dateofBirth, gender, email, password, typeofuser, active);
		this.alumCode = alumCode;
		this.alumInterests = alumInterests;
		this.alumEmployed = alumEmployed;
		this.alumWorkplace = alumWorkplace;
		this.alumAddress = alumAddress;
	}


	//Accessor methods

	public Long getAlumCode() {
		return alumCode;
	}


	public void setAlumCode(Long alumCode) {
		this.alumCode = alumCode;
	}


	public String getAlumInterests() {
		return alumInterests;
	}


	public void setAlumInterests(String alumInterests) {
		this.alumInterests = alumInterests;
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


	//toString returns Alumni Details
	@Override
	public String toString() {
		return "Alumni [alumAddress=" + alumAddress + ", alumCode=" + alumCode + ", alumEmployed=" + alumEmployed
				+ ", alumInterests=" + alumInterests + ", alumWorkplace=" + alumWorkplace + "]";
	}
	
	


}
