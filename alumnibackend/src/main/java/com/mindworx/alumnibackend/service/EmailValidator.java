package com.mindworx.alumnibackend.service;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate{

    @Override
    public boolean test(Object t) {
        //TODO: Redex to validate email
        return true;
    }
    
}
