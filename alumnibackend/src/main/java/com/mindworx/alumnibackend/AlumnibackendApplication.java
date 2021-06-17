package com.mindworx.alumnibackend;



import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.common.base.Charsets;
import com.google.common.io.Files;



// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlumnibackendApplication {

	public static void main(String[] args) {
		// File input = new File("C:/Users/Lenovo-User/Documents/GitHub/MINDWORX-GRP2/alumnibackend/src/main/resources/templates/pages/alumni/posts.html");

		// String pageContent ="";
		// try {
		// 	pageContent = Files.asCharSource(input, StandardCharsets.UTF_8).read();
	    //     System.out.println(pageContent);
		// } catch (IOException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }

		SpringApplication.run(AlumnibackendApplication.class, args);

	}
	

}
 