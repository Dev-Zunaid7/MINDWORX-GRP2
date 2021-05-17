package com.mindworx.alumnibackend.dao;

import java.util.Collection;


import com.mindworx.alumnibackend.model.users.Mindworxuser;


public interface IUserdao {



        //get all users in the database
     Collection<Mindworxuser> getAllMindworxUsers();
        //get a user by id in database
     Mindworxuser getMindworxUserById(int id);
         //remove a user from database
     void removeMindworxUserById(int id);
         //update user details in database
     void updateMindworxUserById(int id,Mindworxuser mindworxuser);  
         //insert user into database
     void innsertMindworxuserToDb(Mindworxuser mindworxUser);
    

}
