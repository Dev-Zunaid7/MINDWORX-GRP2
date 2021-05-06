package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.mindworx.alumnibackend.model.users.User;

public class Alumni extends User {

    public Alumni(Long sSID, String firstName, String lastName, LocalDate dateofBirth, String email, String psw) {
        super(sSID, firstName, lastName, dateofBirth, email, psw);
    }

    //Business methods of an Alumni.
	public List<Alumni> getAlumniDetails(){
		return List.of(
			new Alumni(
				3421l, 
				"Jack", 
				"Wesly", 
				LocalDate.of(1845, Month.FEBRUARY,6), 
				"jWesly@Mindworx.co.za", 
				"*********")
				
			);
	}
    
    
}
