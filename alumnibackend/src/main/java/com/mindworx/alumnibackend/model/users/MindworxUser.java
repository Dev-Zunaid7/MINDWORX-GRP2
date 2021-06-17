/**
 * Class used to access/retrieve/store data from the DATABASE.
 * used to connect to our database
 */

package com.mindworx.alumnibackend.model.users;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class Mindworxuser {

    // These are attributes data of a typical user.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sSID;

    @Column(name = "Name", nullable = false)
    private String firstName;

    @Column(name = "Surname", nullable = false)
    private String lastName;

    @Column(name = "Username", nullable = false)
    private String userName;

    @Column(name = "Initials", nullable = false)
    private String initials;

    @Column(name = "DOB", columnDefinition = "DATE", nullable = false)
    private Date dateofBirth;

    @Column(name = "Gender"

    )
    private String gender;

    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "Password", nullable = false, length = 255)
    private String password;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch=FetchType.EAGER) //fetchtype causes performance problem
    @JoinTable(name = "user_groups", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<MindworxGroup> userGroups = new HashSet<>();

    @Column(name = "Blocked")
    private boolean active = false;

    @Column(name = "Enabled")
    private boolean Enabled = true;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
     

    // constructors to initialize the variables.

    public Mindworxuser() {
    }

    public Mindworxuser(String firstName, String lastName, String userName, String initials, Date dateofBirth,
            String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.initials = initials;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    // accessor methods and store each into databae/retrieve each from database

    public void addUserGroups(MindworxGroup mindworxGroup) {
        userGroups.add(mindworxGroup);
        mindworxGroup.getUsers().add(this);
    }

    public void RemoveUserGroups(MindworxGroup mindworxGroup) {
        userGroups.remove(mindworxGroup);
        mindworxGroup.getUsers().remove(this);
    }

    public Set<MindworxGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<MindworxGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIntials() {
        return initials;
    }

    public void setIntials(String intials) {
        this.initials = intials;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getsSID() {
        return sSID;
    }

    public void setsSID(Long sSID) {
        this.sSID = sSID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    

}
