/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */
package com.mindworx.alumnibackend.model.users.alumni;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.alumni.*;

@Entity
@Table(name = "app_alum")
public class Alumni extends Mindworxuser {

	// Known fields for an Alumni

	// @Column(name = "Alum_Interest", nullable = true)
	// private String alumInterests;
	@OneToMany(mappedBy = "alumni")
    private Set<AlumniInterests> alumInterests;

	@Column(name = "Alum_Employed", nullable = false)
	private boolean alumEmployed;

	@Column(name = "Alum_Workplace", nullable = true)
	private String alumWorkplace;

	@Column(name = "Alum_Address", nullable = true)
	private String alumAddress;

	// Contructor to initialize the fields
	public Alumni() {
	}

	public Alumni(String firstName, String lastName, String userName, String initials, Date dateofBirth, String gender,
			String email, String password, boolean alumEmployed, String alumWorkplace,
			String alumAddress) {
		super(firstName, lastName, userName, initials, dateofBirth, gender, email, password);

		this.alumEmployed = alumEmployed;
		this.alumWorkplace = alumWorkplace;
		this.alumAddress = alumAddress;

		
	}

	// Accessor methods

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

	// toString returns Alumni Details
	@Override
	public String toString() {
		return "Alumni [alumAddress=" + alumAddress + ", alumEmployed=" + alumEmployed +
				 ", alumWorkplace=" + alumWorkplace + "]";
	}

	public Set<AlumniInterests> getAlumInterests() {
		return alumInterests;
	}

	public void setAlumInterests(Set<AlumniInterests> alumInterests) {
		this.alumInterests = alumInterests;
	}

	
}
