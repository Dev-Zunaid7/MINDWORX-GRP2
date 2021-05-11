/**
 * this repository class extends the funtions provided by the JPA data
 * solves the logic of 
 */
package com.mindworx.alumnibackend.model.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
