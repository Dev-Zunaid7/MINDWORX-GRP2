package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.mindworx.alumnibackend.model.users.UserServices;

import org.springframework.stereotype.Service;

@Service
public class AlumniServices extends UserServices<AlumniServices> {


    
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
	@Override
	public List<Alumni> getUserDetails() {
		
		 Alumni alumni0 = new Alumni(1l,"Lilien", "Mellain", LocalDate.of(1839, Month.DECEMBER, 9), 
		 "Lmaelian@student.uj.ac.za", "DUSD77@!8d");
         Alumni alumni1 = new Alumni(2l,"Leon", "Ndaba", LocalDate.of(2000, Month.APRIL, 10), 
		 "Zmani@yahoo.co.za", "^76YDOOl**");
		// this.listUsers.add(alumni0);
		return List.of(alumni0,alumni1);
	}

    
}
