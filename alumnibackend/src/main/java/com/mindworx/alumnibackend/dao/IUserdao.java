package com.mindworx.alumnibackend.dao;


import java.util.Optional;

import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserdao extends JpaRepository<Mindworxuser,Integer> {
    Optional<Mindworxuser> findByEmail(String email);

}
