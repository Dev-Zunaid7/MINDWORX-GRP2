package com.mindworx.alumnibackend.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mindworx.alumnibackend.model.users.Mindworxuser;
import com.mindworx.alumnibackend.model.users.MindworxuserType;

import org.springframework.stereotype.Repository;

@Repository("Fakedao")
public class Userdaoimpl implements IUserdao {
    
    //storage of application data 
        //connect to MindworxDB
    private static List<Mindworxuser> mindworxUsers = new ArrayList<>();



    public Userdaoimpl() {
        mindworxUsers.add(new Mindworxuser(1, "Leon", "Ndaba", "LNdaba", "LV", LocalDate.of(2000, Month.APRIL, 4), true, "LV@gmail.com", "Leon12", MindworxuserType.ALUMNI, true));
        mindworxUsers.add(new Mindworxuser(2, "Jack", "Mcgonal", "MikeJack", "MJ", LocalDate.of(2006, Month.APRIL, 7), true, "MikeJack@mindworx.co.za", "zama32", MindworxuserType.ALUMNI, true));
        mindworxUsers.add(new Mindworxuser(3, "Butle", "Dali", "Dali B", "DB", LocalDate.of(1990, Month.DECEMBER, 14), false, "Butle@Dali.com", "3urnfns", MindworxuserType.COACH, true));
        mindworxUsers.add(new Mindworxuser(4, "Mali", "Mavuso", "MaliO", "MM", LocalDate.of(1903, Month.JUNE, 21), false, "Mali@yahoo.org", "3042j", MindworxuserType.ADMIN, true));
        
    }



    
    

    //get all users in the database
    @Override
    public Collection<Mindworxuser> getAllMindworxUsers(){
        
        return mindworxUsers;
    }

    //get a user by id in database
    @Override
    public Mindworxuser getMindworxUserById(int id){
        //check if id exists
        //throw an id is does not exist exaption        
        return Userdaoimpl.mindworxUsers.get(id);
    }

    //remove a user from database
    @Override
    public void removeMindworxUserById(int id){
        //check if id exists
        //throw an id is does not exist exaption 
        mindworxUsers.remove(id);
        System.out.println("Remove Shit workes!");
    }

    //update user details in database
    @Override
    public void updateMindworxUserById(int id ,Mindworxuser mindworxuser){
               //check if id exists
        //throw an id is does not exist exaption
        
         mindworxUsers.set(id, mindworxuser);
        System.out.println("Update Shit workes!");
    }

    //insert user into database
    @Override
    public void innsertMindworxuserToDb(Mindworxuser mindworxUser) {
        mindworxUsers.add(mindworxUser);
        System.out.println("Insert shit workes!");
    }
}
