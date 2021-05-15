/**
 * this repository class extends the funtions provided by the JPA data
 * solves the logic of 
 */
package com.mindworx.alumnibackend.model.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<AUserDetail, Integer> {
    Optional<AUserDetail> findByUserName(String userName);
}
