package com.mindworx.alumnibackend;


import java.time.LocalDate;
import java.time.Month;

import com.mindworx.alumnibackend.model.users.User;
import com.mindworx.alumnibackend.model.users.UserRepo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    
    @Autowired
    private UserRepo repo;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateAlumniUser(){
        User alumni = new User();

        //Id auto generated.
        alumni.setFirstName("Dollie");
        alumni.setIntials("KL");
        alumni.setLastName("Lane");
        alumni.setUserName("Dolliee");
        alumni.setGender('F');
        alumni.setDateofBirth(LocalDate.of(1505, Month.JUNE, 02));
        alumni.setPsw("ffack");
        alumni.setEmail("Elo@Mnd.co.za");
        alumni.setTypeofuser("alumni");
        alumni.setActive(true);

        //add inserts to data
       User savedUser = repo.save(alumni);

       User existsUser = entityManager.find(User.class, savedUser.getsSID());

     assertThat(existsUser.getEmail()).isEqualTo(alumni.getEmail());
        
    }
}
