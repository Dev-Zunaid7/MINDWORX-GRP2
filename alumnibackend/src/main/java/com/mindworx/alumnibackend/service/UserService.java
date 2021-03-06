package com.mindworx.alumnibackend.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.mindworx.alumnibackend.dao.IUserdao;
import com.mindworx.alumnibackend.dao.MindworxGroupdao;
import com.mindworx.alumnibackend.model.MindworxUserDetails;
import com.mindworx.alumnibackend.model.token.ConfirmationToken;
import com.mindworx.alumnibackend.model.token.ConfirmationTokenService;
import com.mindworx.alumnibackend.model.users.MindworxGroup;
import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.alumni.Alumni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    // accessing the user dao

    private final IUserdao mindworxuserDao;
    MindworxGroupdao mindworxGroupdao;
    private final PasswordEncoder passwordEncoder;
    private final AcademyEmailService academyEmailService;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public UserService(IUserdao mindworxuserDao, MindworxGroupdao mindworxGroupdao, PasswordEncoder passwordEncoder,
            ConfirmationTokenService confirmationTokenService, AcademyEmailService academyEmailService) {
        this.mindworxuserDao = mindworxuserDao;
        this.mindworxGroupdao = mindworxGroupdao;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.academyEmailService = academyEmailService;

    }

    // ADMINISTATOR LEVEL: get all users in the database
    public Collection<Mindworxuser> getAllMindworxUsers() {
        return mindworxuserDao.findAll();
    }

    // //get a user by id in database
    public Optional<Mindworxuser> getMindworxUserById(Long id) {
        // check if the id exist first
        return mindworxuserDao.findById(id);
    }

    // ADMINISTATOR LEVEL: remove a user from database
    public void removeMindworxUserById(Long id) {
        mindworxuserDao.deleteById(id);
    }

    // USER ALUMNI LEVEL: Update user details in database
    @Transactional
    public void updateMindworxUser(long id,Mindworxuser user, String profileImg) {
        Mindworxuser mindworxuser = getMindworxUserById(id).orElseThrow(() -> new UsernameNotFoundException("id doesnt exist"));
        mindworxuser.setProfileImage(profileImg);
        this.mindworxuserDao.saveAndFlush(mindworxuser);
    }

    // SYSTEM LEVEL
    private void innsertMindworxuserToDb(Mindworxuser mindworxUser) {
        this.mindworxuserDao.save(mindworxUser);
    }

    // method for loging in a user security.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // verify user by email
        Mindworxuser mindworxuser = mindworxuserDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
        // update the userdetails to set up login.
        return new MindworxUserDetails(mindworxuser);
    }

    public Alumni getUserbyEmail(String email){
        Alumni mindworxuser = (Alumni) mindworxuserDao.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
        return mindworxuser;
    }

    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
        Mindworxuser mindworxuser = mindworxuserDao.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("We could not find any alumni with the email " + email));
        mindworxuser.setResetPasswordToken(token);
        innsertMindworxuserToDb(mindworxuser);
    }

    public Mindworxuser getByResetPasswordToken(String token) {
        return mindworxuserDao.findByResetPasswordToken(token);
    }

    public void updatePassword(Mindworxuser mindworxuser, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);

        mindworxuser.setPassword(encodedPassword);
        mindworxuser.setResetPasswordToken(null);
        innsertMindworxuserToDb(mindworxuser);
    }

    // methond to add an administratior into database
    public String addAdministrator(Mindworxuser adminstrator) {

        String userType = "admin";
        // verify user by email if already exists on the App's database.
        boolean adminEmailExists = mindworxuserDao.findByEmail(adminstrator.getEmail()).isPresent();
        if (adminEmailExists) {
            throw new IllegalStateException("This admin already exists");
        }

        String encodedPassword = passwordEncoder.encode(adminstrator.getPassword());

        adminstrator.setPassword(encodedPassword);

        // set usertype
        updateCustomerGroup(adminstrator, userType);
        // saving user to the database.
        innsertMindworxuserToDb(adminstrator);

        String token = UUID.randomUUID().toString();
        // create confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), adminstrator);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    // methond to Register the user into database
    public String signUpUser(Mindworxuser mindworxuser) {
        String userType = "alumni";

        // verify user by email if already exists on the App's database.
        boolean userEmailExists = mindworxuserDao.findByEmail(mindworxuser.getEmail()).isPresent();
        if (userEmailExists) {
            //TODO: check if user email has a confirmation token
            //TODO: if not confirmed, send confirmation email again.
            throw new IllegalStateException("This alumni already exists.");
        }

        // validate if the the email exists on the Academy's database.
        boolean isWithAcademy = academyEmailService.IsWithAcademy(mindworxuser.getEmail());
        if (!isWithAcademy) {
            throw new IllegalStateException("You are not one of our Alumni canidates.");
        }
        // validate if email is allowed to register- if email is enabled to register.
        boolean isAllowed = academyEmailService.isAllowed(mindworxuser.getEmail());
        if (!isAllowed) {
            throw new IllegalStateException(
                    "This email " + mindworxuser.getEmail() + " is not allowed/enabled to register.");
        }

        String encodedPassword = passwordEncoder.encode(mindworxuser.getPassword());

        mindworxuser.setPassword(encodedPassword);

        // set usertype
        updateCustomerGroup(mindworxuser, userType);
        // saving user to the database.
        innsertMindworxuserToDb(mindworxuser);

        String token = UUID.randomUUID().toString();
        // create confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), mindworxuser);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    // methond to add an Facilitator/Coach into database
    public String addCoach(Mindworxuser coach) {
        String userType = "coach";

        // verify user by email if already exists on the App's database.
        boolean coachEmailExists = mindworxuserDao.findByEmail(coach.getEmail()).isPresent();
        if (coachEmailExists) {
            throw new IllegalStateException("This facilitator already exists");
        }

        String encodedPassword = passwordEncoder.encode(coach.getPassword());

        coach.setPassword(encodedPassword);
        // set usertype
        updateCustomerGroup(coach, userType);
        // saving user to the database.
        innsertMindworxuserToDb(coach);

        String token = UUID.randomUUID().toString();
        // create confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), coach);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public void enableMindworxUser(String email) {
        // iterate or filter to find the email passed
        Mindworxuser mindworxuser = mindworxuserDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("can not enable issuse"));
        // update the enable of the passed user.
        mindworxuser.setEnabled(true);
    }

    // update the usertype/group
    private void updateCustomerGroup(Mindworxuser mindworxuser, String groupCode) {
        MindworxGroup group = mindworxGroupdao.findByCode(groupCode);
        mindworxuser.addUserGroups(group);
    }

    
}
