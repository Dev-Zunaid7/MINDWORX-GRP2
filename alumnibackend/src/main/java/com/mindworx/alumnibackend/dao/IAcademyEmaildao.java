package com.mindworx.alumnibackend.dao;


import com.mindworx.alumnibackend.model.AcademyEmail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IAcademyEmaildao extends JpaRepository<AcademyEmail,Integer> {

}
