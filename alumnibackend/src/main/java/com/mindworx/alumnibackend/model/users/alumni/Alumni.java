package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mindworx.alumnibackend.model.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alumni extends User<Alumni> {
	

	@Autowired
	public Alumni() {
	}


	public Alumni(Long sSID, String firstName, String lastName, LocalDate dateofBirth, String email, String psw) {
		super(sSID, firstName, lastName, dateofBirth, email, psw);
		//this.listUsers = new ArrayList<Alumni>();
	}

//Business methods of an Alumni.
	
	/**
	 * method to retrive single Alumnus details in the database who is registered.
	 *
	 * @param int ID of the alumnus; pass the index or id of the Alumni as argument.
	 * @return single user alumnis details 
	 */

	/**
	 * 
	 * @return All the Alumni in the database who are registered.
	 */
	@Override
	@JsonManagedReference
	public List<Alumni> getUserDetails() {
		
		 Alumni alumni0 = new Alumni(1l,"Lilien", "Mellain", LocalDate.of(1839, Month.DECEMBER, 9), 
		 "Lmaelian@student.uj.ac.za", "DUSD77@!8d");
		// this.listUsers.add(alumni0);
		return List.of(alumni0);
	}


	/**
	 * @return Alumni data as string to request.
	 */
	@Override
    public String toString() {
        return "Alumni{" +
		"dateofBirth=" + this.getDateofBirth() + 
		", email='" + this.getEmail() + '\'' +
		", firstName=" + this.getFirstName() + '\'' +
		", lastName="  + this.getLastName() + '\'' +
		", psw=" + this.getPsw() + '\'' +
		", sSID=" + this.getsSID() + '}';
    }

}
