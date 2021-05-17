package com.mindworx.alumnibackend.dao;


import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AzureSqlDb")
public interface IUserdao extends JpaRepository<Mindworxuser,Integer> {



    //     //get all users in the database
    //  Collection<Mindworxuser> getAllMindworxUsers();
    //     //get a user by id in database
    //  Mindworxuser getMindworxUserById(int id);
    //      //remove a user from database
    //  void removeMindworxUserById(int id);
    //      //update user details in database
    //  void updateMindworxUserById(int id,Mindworxuser mindworxuser);  
    //      //insert user into database
    //  void innsertMindworxuserToDb(Mindworxuser mindworxUser);
    

}
