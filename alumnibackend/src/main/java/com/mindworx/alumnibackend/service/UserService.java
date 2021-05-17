package com.mindworx.alumnibackend.service;

import java.util.Collection;

import com.mindworx.alumnibackend.dao.Userdaoimpl;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    //accessing the user dao

    private final Userdaoimpl mindworxuserDao;

    
    @Autowired
    public UserService(@Qualifier("Fakedao") Userdaoimpl mindworxuserDao) {
        this.mindworxuserDao = mindworxuserDao;
    }

    public Collection<Mindworxuser> getAllMindworxUsers(){
        return mindworxuserDao.getAllMindworxUsers();
    }

    public Mindworxuser getMindworxUserById(int id){
        //check if the id exist first
        return mindworxuserDao.getMindworxUserById(id);
    }

    public void removeMindworxUserById(int id){
         mindworxuserDao.removeMindworxUserById(id);
    }

    public void updateMindworxUser(int id, Mindworxuser mindworxuser){
       
     this.mindworxuserDao.updateMindworxUserById(id,mindworxuser);
    }

    public void innsertMindworxuserToDb(Mindworxuser mindworxUser) {
        this.mindworxuserDao.innsertMindworxuserToDb(mindworxUser);;
    }
}
