/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */
package com.mindworx.alumnibackend.model.users.alumni;

import java.time.LocalDate;
import com.mindworx.alumnibackend.model.users.User;



public class Alumni extends User {
	



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
