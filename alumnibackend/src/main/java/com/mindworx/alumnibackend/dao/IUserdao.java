package com.mindworx.alumnibackend.dao;


import java.util.Optional;

import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IUserdao extends JpaRepository<Mindworxuser,Long> {
    Optional<Mindworxuser> findByEmail(String email);

}
