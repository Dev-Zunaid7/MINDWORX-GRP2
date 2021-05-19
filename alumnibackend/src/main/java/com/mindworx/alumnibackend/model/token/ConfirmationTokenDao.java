package com.mindworx.alumnibackend.model.token;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken, Integer> {
    //query here for jpa.
    Optional<ConfirmationToken> findByToken(String token);
}
