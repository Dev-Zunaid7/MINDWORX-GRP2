package com.mindworx.alumnibackend.service;

import java.util.Collection;
import java.util.Optional;

import com.mindworx.alumnibackend.dao.IUserdao;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    //accessing the user dao

    private final IUserdao mindworxuserDao;

    
    @Autowired
    public UserService(@Qualifier("AzureSqlDb") IUserdao mindworxuserDao) {
        this.mindworxuserDao = mindworxuserDao;
    }

        //     //get all users in the database
    public Collection<Mindworxuser> getAllMindworxUsers(){
        return mindworxuserDao.findAll();
    }

        //     //get a user by id in database
    public Optional<Mindworxuser> getMindworxUserById(int id){
        //check if the id exist first
        return mindworxuserDao.findById(id);
    }

    //      //remove a user from database
    public void removeMindworxUserById(int id){
         mindworxuserDao.deleteById(id);
    }

    //      //update user details in database
    public void updateMindworxUser(int id, Mindworxuser mindworxuser){
       
     //this.mindworxuserDao.saveAndFlush(id,mindworxuser);
    }

    public void innsertMindworxuserToDb(Mindworxuser mindworxUser) {
        this.mindworxuserDao.save(mindworxUser);
    }
}
