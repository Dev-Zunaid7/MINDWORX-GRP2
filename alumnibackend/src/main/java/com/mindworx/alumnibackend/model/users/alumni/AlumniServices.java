package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.mindworx.alumnibackend.model.users.UserServices;

import org.springframework.stereotype.Service;

@Service
public class AlumniServices extends UserServices {


    
 //Business methods of an Alumni.
     public AlumniServices() {
    }


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
	
	public List getUserDetails() {
		

		return List.of();
	}

    
}
