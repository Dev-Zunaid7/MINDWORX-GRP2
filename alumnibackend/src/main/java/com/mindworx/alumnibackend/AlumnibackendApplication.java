package com.mindworx.alumnibackend;

import com.mindworx.alumnibackend.model.users.UserRepo;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class AlumnibackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumnibackendApplication.class, args);

	}
	

}
 