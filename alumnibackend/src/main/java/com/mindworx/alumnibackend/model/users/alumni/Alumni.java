package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.mindworx.alumnibackend.model.users.User;

import org.springframework.stereotype.Service;

@Service
public class Alumni extends User {
	
	public Alumni(Long sSID, String firstName, String lastName, LocalDate dateofBirth, String email, String psw) {
		super(sSID, firstName, lastName, dateofBirth, email, psw);
	}

	public Alumni() {
	}

	//Business methods of an Alumni.
	public List<Alumni> getAlumniDetails(){
		Alumni alumni0 = new Alumni(
			3421l, 
			"Jack", 
			"Wesly", 
			LocalDate.of(1845, Month.FEBRUARY,6), 
			"jWesly@Mindworx.co.za", 
			"*********");

			Alumni alumni1 = new Alumni(
				3421l, 
				"ack", 
				"ely", 
				LocalDate.of(2345, Month.FEBRUARY,6), 
				"jWesly@Mindworx.co.za", 
				"*********");			
			
		return List.of(alumni1);
	}
    
    
}
